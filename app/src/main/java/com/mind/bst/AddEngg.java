package com.mind.bst;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddEngg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1;
    String URL= "http://192.168.0.27/add_engineers/index.php";

    JSONParser jsonParser=new JSONParser();
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_engg);
        getSupportActionBar().setTitle("Add Engineer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
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

                    AttemptLogin attemptLogin= new AttemptLogin();
                    attemptLogin.execute(
                            e1.getText().toString(),
                            e2.getText().toString(),
                            e3.getText().toString(),
                            e4.getText().toString(),
                            e5.getText().toString(),
                            "");


                    /*Intent i=new Intent(AddClient.this,NewCall1.class);
                    startActivity(i);*/


                }

            }
        });

    }



    private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected JSONObject doInBackground(String... args) {



           /* String email = args[2];
            String password = args[1];
            String name= args[0];*/

            String region= args[0];
            String name= args[1];
            String address= args[2];
            String contact= args[3];
            String email= args[4];







            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
           /* params.add(new BasicNameValuePair("username", name));
            params.add(new BasicNameValuePair("password", password));*/

            params.add(new BasicNameValuePair("region", region));
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("address", address));
            params.add(new BasicNameValuePair("contact_no", contact));
            params.add(new BasicNameValuePair("email_id", email));


            /*if(email.length()>0)
                params.add(new BasicNameValuePair("email",email));*/

            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    //Toast.makeText(TestPhp.this, "success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Engineer added successfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(AddEngg.this,AdminActivity.class);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }
}
