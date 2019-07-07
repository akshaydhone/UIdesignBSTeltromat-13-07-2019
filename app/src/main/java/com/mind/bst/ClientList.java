package com.mind.bst;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClientList extends ArrayAdapter<Data> {
    private Activity context;
    List<Data> clients;

    public ClientList(Activity context, List<Data> clients) {
        super(context, R.layout.activity_client_list, clients);
        this.context = context;
        this.clients = clients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_client_list, null, true);

        TextView textViewRegion = (TextView) listViewItem.findViewById(R.id.textRegion);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textName);

        TextView textViewAdd = (TextView) listViewItem.findViewById(R.id.textAdd);
        TextView textViewCont = (TextView) listViewItem.findViewById(R.id.textCont);

        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textEmail);



        //TextView textViewRegion=(TextView)listViewItem.findViewById(R.id.textRegion)
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);


        Data data = clients.get(position);
        textViewName.setText(data.getName());
        textViewAdd.setText(data.getAddress());
        textViewCont.setText(data.getContact());
        textViewRegion.setText(data.getRegion());
        textViewEmail.setText(data.getEmail());


        return listViewItem;
    }
}