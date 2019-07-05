package com.mind.bst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.onesignal.OneSignal;

public class AdminActivity extends AppCompatActivity {
    CardView b1,b2,b3,b4;
    LinearLayout ll;
    private FirebaseAuth mAuth;
    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Admin Dashboard");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ll=(LinearLayout)findViewById(R.id.ll);
        b1=(CardView)findViewById(R.id.b1);
        b2=(CardView)findViewById(R.id.b2);
        b3=(CardView)findViewById(R.id.b3);
        b4=(CardView)findViewById(R.id.b4);
        //username=(TextView)findViewById(R.id.username) ;
         username=(TextView)findViewById(R.id.username);


        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not

        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


       /* FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);

        if (user != null) {
            username.setText("Welcome admin, " + user.getEmail());



            LoginActivity.LoggedIn_User_Email =user.getEmail();




        }*/




        //Fetch the Display name of current User
        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);

        /*if (user != null) {
            username.setText("Welcome, " + user.getEmail());



            LoginActivity.LoggedIn_User_Email =user.getEmail();




        }*/


         //for adding clients
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminActivity.this,TestPhp.class);
                startActivity(i);
            }
        });

        //for adding engineers
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminActivity.this,AddEngg.class);
                startActivity(i);
            }
        });


        //For Viewing Calls

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminActivity.this,MainChatActivity.class);
                startActivity(i);
            }
        });



        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.signout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        return true;
    }

}
