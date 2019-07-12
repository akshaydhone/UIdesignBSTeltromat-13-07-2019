package com.mind.bst;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ViewCalls extends ArrayAdapter<DisplayCalls> {
    private Activity context;
    List<DisplayCalls> clients;

    public ViewCalls(Activity context, List<DisplayCalls> clients) {
        super(context, R.layout.activity_view_calls, clients);
        this.context = context;
        this.clients = clients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_view_calls, null, true);

        TextView textViewRegion = (TextView) listViewItem.findViewById(R.id.status);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.member_name);

       // TextView textViewAdd = (TextView) listViewItem.findViewById(R.id.textAdd);
        //TextView textViewCont = (TextView) listViewItem.findViewById(R.id.textCont);

        ImageView imageViewPic = (ImageView) listViewItem.findViewById(R.id.profile_pic);



        //TextView textViewRegion=(TextView)listViewItem.findViewById(R.id.textRegion)
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);


        DisplayCalls data = clients.get(position);
        textViewName.setText(data.getEngineer());
       // textViewAdd.setText(data.getAddress());
        //textViewCont.setText(data.getContact());
        textViewRegion.setText(data.getCity());
      //  imageViewPic.setImageBitmap();
        //textViewEmail.setText(data.getEmail());



        return listViewItem;
    }
}