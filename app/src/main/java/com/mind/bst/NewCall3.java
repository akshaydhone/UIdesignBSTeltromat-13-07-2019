package com.mind.bst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewCall3 extends AppCompatActivity {
    private static final String TAG = "NewCall3";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    EditText e1,e2;
    Button b1;
    Spinner s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call3);

       getSupportActionBar().setTitle("Status and observation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        b1=(Button)findViewById(R.id.b1);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();


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




                else{


                    String observation = e1.getText().toString();
                    mEditor.putString(getString(R.string.observation), observation);
                    mEditor.commit();


                    String remark = e2.getText().toString();
                    mEditor.putString(getString(R.string.remark), remark);
                    mEditor.commit();


                    Intent i=new Intent(NewCall3.this,NewCall4.class);
                    startActivity(i);

                }
            }
        });


    }

    private void checkSharedPreferences() {

        String observation = mPreferences.getString(getString(R.string.observation), "");
        String remark = mPreferences.getString(getString(R.string.remark), "");



        e1.setText(observation);
        e2.setText(remark);
    }
}
