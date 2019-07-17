package com.mind.bst;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ProfileActivity extends ArrayAdapter<UserInformation> {

    private Activity context;
    List<UserInformation> clients;

    ImageView profile;
    TextView profile_name, profile_email, profile_phone, profile_address, profile_region;


    public ProfileActivity(Activity context, List<UserInformation> clients) {
        super(context, R.layout.activity_profile, clients);
        this.context = context;
        this.clients = clients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_profile, null, true);

        profile = (ImageView) listViewItem.findViewById(R.id.profile);
        profile_name = (TextView) listViewItem.findViewById(R.id.profile_name);
        profile_email = (TextView) listViewItem.findViewById(R.id.profile_email);
        profile_phone = (TextView) listViewItem.findViewById(R.id.profile_phone);
        profile_address = (TextView) listViewItem.findViewById(R.id.profile_address);
        profile_region = (TextView) listViewItem.findViewById(R.id.profile_region);





        UserInformation data = clients.get(position);

        profile_name.setText(data.getName());
        profile_email.setText(data.getEmail());
        profile_phone.setText(data.getContact());
        profile_address.setText(data.getAddress());
        profile_region.setText(data.getRegion());
       Picasso.with(context).load(data.getImage_Url().toString()).into(profile);




        return listViewItem;
    }
}
