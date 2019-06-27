package com.mind.loginregisterapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PendingCall extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_call);
        getSupportActionBar().setTitle("New  Call Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView=(ListView)findViewById(R.id.listView);

        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");
        arrayList.add("Mohan Sharma");
        arrayList.add("Shravan singh");
        arrayList.add("Narendra mehta");
        arrayList.add("Akash chopra");
        arrayList.add("Ajinkya dhaval");
        arrayList.add("Paresh patel");
        arrayList.add("Navjot Sahani");









        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(PendingCall.this, "You Clicked" +i+  ""+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}
