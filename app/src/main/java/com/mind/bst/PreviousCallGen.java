package com.mind.bst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreviousCallGen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_call_gen);
        getSupportActionBar().setTitle("Previous Call generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
