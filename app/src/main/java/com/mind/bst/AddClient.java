package com.mind.bst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddClient extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;


    //DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        getSupportActionBar().setTitle("Add Client");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);

        databaseReference=db.getReference("Clients");


        b1=(Button)findViewById(R.id.b1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("Region not entered");
                    e1.requestFocus();
                }

                else if(e2.getText().toString().trim().length()==0)
                {
                    e2.setError("Name not entered");
                    e2.requestFocus();
                }


                else if(e3.getText().toString().trim().length()==0)
                {
                    e3.setError("Address not entered");
                    e3.requestFocus();
                }


                else if(e4.getText().toString().trim().length()==0)
                {
                    e4.setError("Contact no not entered");
                    e4.requestFocus();
                }

                else if(e5.getText().toString().trim().length()==0)
                {
                    e5.setError("Email-Id not entered");
                    e5.requestFocus();
                }



                else{
                    sendData();
                    Intent i=new Intent(AddClient.this,AdminActivity.class);
                    startActivity(i);



                }

            }
        });


    }


    public void sendData(){
        String e1Text=e1.getText().toString();
        String e2Text=e2.getText().toString();
        String e3Text=e3.getText().toString();
        String e4Text=e4.getText().toString();
        String e5Text=e5.getText().toString();

        String id=databaseReference.push().getKey();

        if(!TextUtils.isEmpty(e1Text) && (!TextUtils.isEmpty(e2Text)) && (!TextUtils.isEmpty(e3Text))  && (!TextUtils.isEmpty(e5Text)) && (!TextUtils.isEmpty(e4Text)))
        {
            Data data=new Data(id,e1Text,e2Text,e3Text,e5Text,e4Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Client added Successfully", Toast.LENGTH_SHORT).show();

        }


    }
}
