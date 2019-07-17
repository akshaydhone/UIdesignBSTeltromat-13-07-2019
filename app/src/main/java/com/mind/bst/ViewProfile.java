package com.mind.bst;

import android.provider.ContactsContract;
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

public class ViewProfile extends AppCompatActivity {

    public static final String CLIENT_NAME = "com.mind.bst.clientname";
    public static final String CLIENT_ID = "com.mind.bst.clientid";
    ListView listViewClients;

    //here data is a java class name
    List<UserInformation> clients;
    //selecting a database ref
    DatabaseReference databaseClients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        getSupportActionBar().setTitle("View Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting the root name database table
        databaseClients = FirebaseDatabase.getInstance().getReference("Users");
        //listViewClients = (ListView) findViewById(R.id.listViewClients);
        listViewClients=(ListView)findViewById(R.id.listViewClients);


//storing clients in array list
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
                    UserInformation data = postSnapshot.getValue(UserInformation.class);
                    //adding clients to the list
                    clients.add(data);

                }

                //creating adapter
                ProfileActivity artistAdapter = new ProfileActivity(ViewProfile.this, clients);
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
