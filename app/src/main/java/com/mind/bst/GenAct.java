package com.mind.bst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GenAct extends AppCompatActivity {
    ListView listViewClients;
    List<Total> clients;

    DatabaseReference databaseClients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);
        getSupportActionBar().setTitle("Call Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated");
        listViewClients = (ListView) findViewById(R.id.listViewClients);
        clients = new ArrayList<>();

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
                    clients.add(data);

                }

                //creating adapter
                GeneratedList artistAdapter = new GeneratedList(GenAct.this, clients);
                //attaching adapter to the listview
                listViewClients.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
