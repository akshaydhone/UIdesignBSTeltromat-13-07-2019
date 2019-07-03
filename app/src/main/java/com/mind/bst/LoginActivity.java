package com.mind.bst;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.onesignal.OneSignal;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
    private Button signin, signup;
    FirebaseUser user;
    static String LoggedIn_User_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Page");
        OneSignal.startInit(this).init();
        mAuth = FirebaseAuth.getInstance(); // important Call

        email = (EditText)findViewById(R.id.e1);
        password = (EditText)findViewById(R.id.e2);
        signin=(Button)findViewById(R.id.b1);

        if(mAuth.getCurrentUser() != null)
        {
            //User NOT logged In
            finish();
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }
        user = mAuth.getCurrentUser();
        Log.d("LOGGED", "user: " + user);


        //Setting the tags for Current User.
        if (user != null) {
            LoggedIn_User_Email =user.getEmail();
        }
        OneSignal.sendTag("User_ID", LoggedIn_User_Email);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getemail = email.getText().toString().trim();
                String getepassword = password.getText().toString().trim();

                if(getemail.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Type Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(getepassword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Type Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                callsignin(getemail,getepassword);

            }
        });






    }


    private void callsignin(final String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TESTING", "sign In Successful:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("TESTING", "signInWithEmail:failed", task.getException());
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }


                        else if(email.equals("rajesh@gmail.com"))
                        {
                            Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                            finish();
                            startActivity(i);
                            Toast.makeText(LoginActivity.this, "Logged in as admin", Toast.LENGTH_SHORT).show();
                        }

                        else if(email.equals("Rajesh@gmail.com"))
                        {
                            Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                            finish();
                            startActivity(i);
                            Toast.makeText(LoginActivity.this, "Logged in as admin", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            finish();
                            startActivity(i);
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



}
