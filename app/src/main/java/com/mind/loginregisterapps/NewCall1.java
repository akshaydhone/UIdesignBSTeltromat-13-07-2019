package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewCall1 extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call1);

       getSupportActionBar().setTitle("New  Call Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);

        s1=(Spinner)findViewById(R.id.s1);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(NewCall1.this,NewCall2.class);
                startActivity(i);
                /*if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("Email not entered");
                    e1.requestFocus();
                }

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Date not Generated");
                    e2.requestFocus();
                }


                else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("IN time not entered");
                    e3.requestFocus();
                }
               else if(s1.equals("Select a Product"))
                {
                    Toast.makeText(NewCall1.this, "Please select a product", Toast.LENGTH_SHORT).show();
                }



          else if(e4.getText().toString().trim().equals(""))
                {
                     e4.setError("Product serial No. not entered");
                   e4.requestFocus();
                }





                else{

                }*/
            }
        });
    }
}
