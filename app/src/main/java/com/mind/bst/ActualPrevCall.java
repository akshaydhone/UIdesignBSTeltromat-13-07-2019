package com.mind.bst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActualPrevCall extends AppCompatActivity {
    ListView listViewClients;
    List<Total> clients;

    DatabaseReference databaseClients;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_prev_call);
        getSupportActionBar().setTitle("Call Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated");
        listViewClients = (ListView) findViewById(R.id.listViewClients);
        clients = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance(); // important Call
        //Again check if the user is Already Logged in or Not

        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseClients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                clients.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Total data = postSnapshot.getValue(Total.class);
                    //adding artist to the list
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d("LOGGED", "FirebaseUser: " + user);
                    postSnapshot.child(user.getUid());
                    clients.add(data);

                }

                //creating adapter
                PrevImg artistAdapter = new PrevImg(ActualPrevCall.this, clients);
                //attaching adapter to the listview
                listViewClients.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
