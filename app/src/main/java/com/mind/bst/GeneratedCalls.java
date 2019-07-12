package com.mind.bst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class GeneratedCalls extends AppCompatActivity {
    ListView listViewClients;

    List<DisplayCalls> clients;
    //selecting a database ref
    DatabaseReference databaseClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_calls);

        getSupportActionBar().setTitle("Calls generated");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated");
        listViewClients=(ListView)findViewById(R.id.listViewClients);

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


            //when a data is changed reflect it into the database
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                clients.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //gettingclients
                    DisplayCalls data = postSnapshot.getValue(DisplayCalls.class);
                    //adding clients to the list
                    clients.add(data);

                }

                //creating adapter
                ViewCalls artistAdapter = new ViewCalls(GeneratedCalls.this, clients);
                //attaching adapter to the listview
                listViewClients.setAdapter(artistAdapter);
            }


            //providing error if data not matched or database error
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
