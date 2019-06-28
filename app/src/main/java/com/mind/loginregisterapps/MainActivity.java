package com.mind.loginregisterapps;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import com.onesignal.OneSignal;



public class MainActivity extends AppCompatActivity {

   // private ImageButton btRegister;
    private TextView tvLogin;
private RelativeLayout texthome;
    private Button b1,b2;
    private EditText e1,e2;
    private Animation frombottom;


    String URL= "http://192.168.0.27/test_android/index.php";

    JSONParser jsonParser=new JSONParser();

    int i=0;

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
        b2=(Button)findViewById(R.id.b2);

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (e1.getText().toString().trim().length() == 0) {
                    e1.setError("Username not entered");
                    e1.requestFocus();
                }
                else if (e2.getText().toString().trim().length() == 0) {
                    e2.setError("Password not Generated");
                    e2.requestFocus();
                }





                else
                {
                    AttemptLogin attemptLogin = new AttemptLogin();
                    attemptLogin.execute(e1.getText().toString(), e2.getText().toString(), "");

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




            String password = args[1];
            String name= args[0];

            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", name));
            params.add(new BasicNameValuePair("password", password));


            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message1"),Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);
                }

            else if (result != null){

                    Toast.makeText(getApplicationContext(),result.getString("message0"),Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

}

