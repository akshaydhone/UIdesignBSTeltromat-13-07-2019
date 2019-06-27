package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class NewCall2 extends AppCompatActivity {
    Spinner s1;
    EditText e1,e2,e3,e4;
    Button b1;


    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call2);

      getSupportActionBar().setTitle("New  Call Generation");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        s1 = (Spinner) findViewById(R.id.s1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(NewCall2.this,NewCall3.class);
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


                else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("Please fill the details");
                    e3.requestFocus();
                }


                else{


                }*/
            }
        }

        );




    }




}

