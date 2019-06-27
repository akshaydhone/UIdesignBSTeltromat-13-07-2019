package com.mind.loginregisterapps;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // private ImageButton btRegister;
    private TextView tvLogin;
    private RelativeLayout texthome;
    private Button b1;
    private Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        texthome = (RelativeLayout) findViewById(R.id.texthome);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        //btRegister  = findViewById(R.id.btRegister);

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });




//        btRegister.setOnClickListener(this);
    }

}