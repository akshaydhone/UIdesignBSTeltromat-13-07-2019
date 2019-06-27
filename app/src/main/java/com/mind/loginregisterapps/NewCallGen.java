package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewCallGen extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call_gen);
    getSupportActionBar().setTitle("New  Call Generation");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);

        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("City not entered");
                    e1.requestFocus();
                }

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Name not entered");
                    e2.requestFocus();
                }


                else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("Client's Name not entered");
                    e3.requestFocus();
                }


            else if(e4.getText().toString().trim().length()==0)
                {
                    e4.setError("Address not entered");
                    e4.requestFocus();
                }*/

                Intent i=new Intent(NewCallGen.this,NewCall1.class);
                startActivity(i);



                /*else{

                }*/

            }
        });


    }
}
