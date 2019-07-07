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

public class ViewClients extends AppCompatActivity {

    public static final String CLIENT_NAME = "com.mind.bst.clientname";
    public static final String CLIENT_ID = "com.mind.bst.clientid";
    ListView listViewClients;
    List<Data> clients;

    DatabaseReference databaseClients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clients);

        databaseClients = FirebaseDatabase.getInstance().getReference("Clients");
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
                    Data data = postSnapshot.getValue(Data.class);
                    //adding artist to the list
                    clients.add(data);

                }

                //creating adapter
             ClientList artistAdapter = new ClientList(ViewClients.this, clients);
                //attaching adapter to the listview
                listViewClients.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
