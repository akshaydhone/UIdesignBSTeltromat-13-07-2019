package com.mind.bst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class PrevActual extends AppCompatActivity {

    public static final String CLIENT_NAME = "com.mind.bst.clientname";
    public static final String CLIENT_ID = "com.mind.bst.clientid";
    ListView listViewClients;

    //here data is a java class name
    List<Total> clients;
    //selecting a database ref
    DatabaseReference databaseClients;
    FirebaseUser user;
    String uid;


    public static final String Region = "com.mind.bst.region";
    public static final String clientname = "com.mind.bst.clientname";
    public static final String clientaddress = "com.mind.bst.address";
    public static final String clientcontact = "com.mind.bst.contact";
    public static final String clientemail = "com.mind.bst.email";
    public static final String clienturl = "com.mind.bst.url";
    public static final String clientremark = "com.mind.bst.remark";
    public static final String date = "com.mind.bst.date";


    public static final String detailofcomplaint = "com.mind.bst.detailofcomplaint";
    public static final String enggname = "com.mind.bst.enggname";
    public static final String enggobs = "com.mind.bst.enggobs";
    public static final String natureofcomplaint = "com.mind.bst.natureofcomplaint";



    public static final String payment = "com.mind.bst.payment";
    public static final String proname = "com.mind.bst.proname";
    public static final String prosrno = "com.mind.bst.prosrno";
    public static final String statusofcomplaint = "com.mind.bst.statusofcomplaint";
    public static final String time = "com.mind.bst.time";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_actual);
        getSupportActionBar().setTitle("Client Visits");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting the root name database table
        databaseClients = FirebaseDatabase.getInstance().getReference("Calls Generated");
        //listViewClients = (ListView) findViewById(R.id.listViewClients);
        listViewClients=(ListView)findViewById(R.id.listViewClients);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();


//storing clients in array list
        clients = new ArrayList<>();


        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                Total data = clients.get(position);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), ActualPrevCall.class);

                //putting artist name and id to intent
                intent.putExtra(Region, data.getCity());
                intent.putExtra(clientname, data.getClient());
                intent.putExtra(clientaddress, data.getClient_add());
                intent.putExtra(clientcontact, data.getClient_cont());
                intent.putExtra(clientemail, data.getClient_email());



                intent.putExtra(clienturl, data.getClient_image_url());
                intent.putExtra(clientremark, data.getClient_remark());
                intent.putExtra(date, data.getDate());
                intent.putExtra(detailofcomplaint, data.getDetails_of_complaint());


                intent.putExtra(enggname, data.getEngineer());
                intent.putExtra(enggobs, data.getEngineer_observation());
                intent.putExtra(natureofcomplaint, data.getNature_of_complaint());
                intent.putExtra(payment, data.getPayment_via());
                intent.putExtra(proname, data.getProduct_name());


                intent.putExtra(statusofcomplaint, data.getStatus_of_complaint());

                intent.putExtra(prosrno, data.getProduct_serial_no());
                intent.putExtra(time, data.getTime());



                //starting the activity with intent
                startActivity(intent);


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
                    Total data = postSnapshot.getValue(Total.class);
                    //adding clients to the list
                    clients.add(data);

                }

                //creating adapter
              ViewClientCallsImg artistAdapter = new ViewClientCallsImg(PrevActual.this, clients);
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
