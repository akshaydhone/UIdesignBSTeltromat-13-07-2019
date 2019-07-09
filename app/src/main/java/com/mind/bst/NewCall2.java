package com.mind.bst;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class NewCall2 extends AppCompatActivity {

    private static final String TAG = "NewCall2";
//step1
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    Spinner s1;
    EditText e1,e2,e3,e4;
    Button b1;


    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call2);

      getSupportActionBar().setTitle("Product and complaint details");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Spinner s1 = (Spinner) findViewById(R.id.s1);



        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);






        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        b1=(Button)findViewById(R.id.b1);
         //step2
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

     // String check= s1.getText().toString();








        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("spinner",s1.getSelectedItem().toString());

                String savedValue=PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext())
                        .getString("spinner","");


                for(int i=0;i<5;i++)
                    if(savedValue.equals(s1.getItemAtPosition(i).toString())){
                        s1.setSelection(i);
                        break;
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(e1.getText().toString().trim().length()==0)
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

                      //save the pserial
                    String pserial = e1.getText().toString();
                    mEditor.putString(getString(R.string.pserial), pserial);
                    mEditor.commit();

                    //save the nature
                    String nature = e2.getText().toString();
                    mEditor.putString(getString(R.string.nature), nature);
                    mEditor.commit();

                    //save the details
                    String details = e3.getText().toString();
                    mEditor.putString(getString(R.string.details), details);
                    mEditor.commit();

                    //save the spinner...//step3
                    //String spinner = s1.toString();
                   // mEditor.putString(getString(R.string.spinner), spinner);
                    //mEditor.commit();


                    SharedPreferences prefs;
                    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor prefEditor = prefs.edit();
                    prefEditor.putString("spinner",s1.getSelectedItem().toString());
                    prefEditor.commit();



                    Intent i=new Intent(NewCall2.this,NewCall3.class);
                    startActivity(i);

                }
            }
        }

        );




    }

    private void checkSharedPreferences() {


        String pserial = mPreferences.getString(getString(R.string.pserial), "");
        String nature = mPreferences.getString(getString(R.string.nature), "");
        String details = mPreferences.getString(getString(R.string.details), "");
        String spinner = mPreferences.getString(getString(R.string.spinner), "");







   //s1.();

        e1.setText(pserial);
        e2.setText(nature);
        e3.setText(details);


    }


}

