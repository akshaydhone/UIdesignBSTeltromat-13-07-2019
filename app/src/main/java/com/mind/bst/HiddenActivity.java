package com.mind.bst;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static com.mind.bst.CameraActivity.READ_EXTERNAL_STORAGE;
import static com.mind.bst.OpenCamera.RequestPermissionCode;

public class HiddenActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password,name,eregion,eadd,econt;
    private Button  signup,select_image;
    FirebaseUser user;
    public static ImageView user_image;
    public static TextView url;
    static String LoggedIn_User_Email;

    private static final int GALLERY_INTENT = 2;
    public static FirebaseDatabase mDatabase;
    private ProgressDialog progressDialog;
    //private FirebaseDatabase mRoofRef;
    private StorageReference mStorage;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        getSupportActionBar().setTitle("Add Engineer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            //mDatabase.setPersistenceEnabled(true);
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }


        mAuth = FirebaseAuth.getInstance(); // important Call

        //signin = (Button)findViewById(R.id.signin);
        signup = (Button)findViewById(R.id.signup);
        email = (EditText)findViewById(R.id.etEmail);
        password = (EditText)findViewById(R.id.etPassword);
        name = (EditText)findViewById(R.id.etName);
        eregion = (EditText)findViewById(R.id.e1);
        eadd = (EditText)findViewById(R.id.e3);
        econt = (EditText)findViewById(R.id.e4);
        select_image = (Button)findViewById(R.id.select_image);
        user_image = (ImageView) findViewById(R.id.user_image);
        url=(TextView)findViewById(R.id.url) ;
        progressDialog = new ProgressDialog(HiddenActivity.this);
        EnableRuntimePermission();


        //Check if User is Already LoggedIn
        //if(mAuth.getCurrentUser() != null)
        //{
            //User NOT logged In
           // finish();
            //startActivity(new Intent(getApplicationContext(),SignIn.class));
          //  Toast.makeText(this, "Already logged in", Toast.LENGTH_SHORT).show();

        //}

        user = mAuth.getCurrentUser();
        Log.d("LOGGED", "user: " + user);


        if (user != null) {
            LoggedIn_User_Email =user.getEmail();
        }




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String getemail = email.getText().toString().trim();
                String getepassword = password.getText().toString().trim();



                String getname = name.getText().toString().trim();
                String getregion = eregion.getText().toString().trim();

                String getadd = eadd.getText().toString().trim();
                String getcont = econt.getText().toString().trim();

                if(getemail.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(getepassword.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(getepassword.length()<6){
                    Toast.makeText(HiddenActivity.this, "Password should minimum 6 Character", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(getname.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Name", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(getregion.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Region", Toast.LENGTH_SHORT).show();
                    return;
                }



                if(getadd.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(getcont.isEmpty()){
                    Toast.makeText(HiddenActivity.this, "Type Contact number", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(getcont.length()<10){
                    Toast.makeText(HiddenActivity.this, "Invalid Contact number", Toast.LENGTH_SHORT).show();
                    return;
                }


                callsignup(getemail,getepassword);

            }
        });


        mStorage = FirebaseStorage.getInstance().getReferenceFromUrl("gs://uidesignbsteltromat.appspot.com/");




        select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HiddenActivity.this);
                //builder.setMessage("Select Photo");
                builder.setTitle("Select From");

                builder.setCancelable(true);

                builder.setPositiveButton("Gallery", new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {

                        // When the user click yes button
                        // then app will close
                        //Check for Runtime Permission
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                            {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                            }
                        }
                        else
                        {
                            callgalary();
                        }

                    }
                });



               /* builder
                        .setNegativeButton(
                                "Camera",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                                        startActivityForResult(intent, 7);

                                    }
                                });*/

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();

            }
        });


    }
    private void callgalary() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT);



    }




    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(HiddenActivity.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(HiddenActivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(HiddenActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }






    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            final Uri mImageUri = data.getData();
            user_image.setImageURI(mImageUri);
            final StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

            progressDialog.setMessage("Uploading Image....");
            progressDialog.show();


            filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                    //mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                    Glide.with(getApplicationContext())
                            .load(downloadUri)
                            .crossFade()
                            .placeholder(R.drawable.loading)
                            .diskCacheStrategy(DiskCacheStrategy.RESULT)
                            .into(user_image);

                    Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    String abc= taskSnapshot.getDownloadUrl().toString();
                    url.setText(abc);

                }
            });


            /*url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NewCall4.this, "download " +filePath.getDownloadUrl(), Toast.LENGTH_SHORT).show();
                    //filePath.getDownloadUrl();
                   // mStorage.getDownloadUrl();
                }
            });*/
        }

        /*if (requestCode == 7 && resultCode == RESULT_OK) {

            //Uri mImageUri = data.getData();
            //user_image.setImageURI(mImageUri);

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            user_image.setImageBitmap(bitmap);
            //StorageReference filePath = mStorage.child("User_Images").child("gs://uidesignbsteltromat.appspot.com/");







        }*/
    }



    //Create Account
    private void callsignup(String email,String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(HiddenActivity.this, "Signed up Failed", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            userProfile();



                            FirebaseUser user = mAuth.getCurrentUser();
                            String UserID=user.getEmail().replace("@","").replace(".","");
                            DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

                            DatabaseReference ref1= mRootRef.child("Users").child(UserID);

                            ref1.child("Name").setValue(name.getText().toString().trim());
                            ref1.child("Image_Url").setValue(url.getText().toString().trim());
                            ref1.child("Email").setValue(user.getEmail());
                            ref1.child("Region").setValue(eregion.getText().toString().trim());
                            ref1.child("Address").setValue(eadd.getText().toString().trim());
                            ref1.child("Contact").setValue(econt.getText().toString().trim());




                            Log.d("TESTING", "Sign up Successful" + task.isSuccessful());
                            Toast.makeText(HiddenActivity.this, "Account Created ", Toast.LENGTH_SHORT).show();
                            Log.d("TESTING", "Created Account");

                            Intent i=new Intent(HiddenActivity.this,AdminActivity.class);

                            startActivity(i);
                        }
                    }
                });
    }


    //Set UserDisplay Name
    private void userProfile()
    {
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!= null)
        {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name.getText().toString().trim())
                    //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))  // here you can set image link also.
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TESTING", "User profile updated.");
                            }
                        }
                    });
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    callgalary();
                return;
        }




        //Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
    }

}
