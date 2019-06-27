package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewCall3 extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    Spinner s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call3);
       getSupportActionBar().setTitle("New  Call Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        b1=(Button)findViewById(R.id.b1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(NewCall3.this,NewCall4.class);
                startActivity(i);

                /*if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("Please fill the details");
                    e1.requestFocus();
                }

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Please fill the details");
                    e2.requestFocus();
                }




                else{

                }*/
            }
        });


    }
}
