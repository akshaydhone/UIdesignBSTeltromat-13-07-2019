package com.mind.bst;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;

public class NewCall1 extends AppCompatActivity {

    private static final String TAG = "NewCall1";
    //private static final String TAG = "SecondActivity";
    EditText e1, e2;

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    //String URL= "http://192.168.0.27/callgen/index.php";

    // JSONParser jsonParser=new JSONParser();
    //int i=0;


    Button b1;
    Spinner s1;
    TimePickerDialog picker;

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call1);

        getSupportActionBar().setTitle("New  Call Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        mDisplayDate = (TextView) findViewById(R.id.e3);
        mDisplayTime = (TextView) findViewById(R.id.e4);

        s1 = (Spinner) findViewById(R.id.s1);
        b1 = (Button) findViewById(R.id.b1);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String city = mPreferences.getString(getString(R.string.city), "");
        String name = mPreferences.getString(getString(R.string.name), "");

        String client = mPreferences.getString(getString(R.string.client), "");
        String add = mPreferences.getString(getString(R.string.add), "");



        databaseReference=db.getReference("Calls Generated");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (e1.getText().toString().trim().length() == 0) {
                    e1.setError("Email not entered");
                    e1.requestFocus();
                } else if (e2.getText().toString().trim().length() == 0) {
                    e2.setError("Date not Generated");
                    e2.requestFocus();
                } else {


                    //sendData();
                   /* AttemptLogin attemptLogin= new AttemptLogin();
                    attemptLogin.execute(
                            e1.getText().toString(),
                            e2.getText().toString(),

                            "");*/
                    Intent i = new Intent(NewCall1.this, NewCall2.class);
                    startActivity(i);

                }
            }
        });


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewCall1.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };


        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minutes = cal.get(Calendar.MINUTE);


                picker = new TimePickerDialog(NewCall1.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                mDisplayTime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);


                picker.show();


            }
        });


    }



    public void sendData(){
        String e5Text=e1.getText().toString();
        String e6Text=e2.getText().toString();



    String id=databaseReference.push().getKey();

        if(!TextUtils.isEmpty(e5Text) && (!TextUtils.isEmpty(e6Text)))
        {
            DataDetail1 data=new DataDetail1(id,e5Text,e6Text);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "Call generated Successfully", Toast.LENGTH_SHORT).show();

        }


    }


}


    /*private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected JSONObject doInBackground(String... args) {






            String cust_contact_no= args[0];

            String cust_email_id= args[1];







            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();


            params.add(new BasicNameValuePair("cust_contact_no", cust_contact_no));
            params.add(new BasicNameValuePair("cust_email_id", cust_email_id));




            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {



            try {
                if (result != null) {
                    //Toast.makeText(TestPhp.this, "success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(NewCall1.this,NewCall2.class);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }*/




