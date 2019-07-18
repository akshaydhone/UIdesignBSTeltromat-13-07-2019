package com.mind.bst;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ViewClientCallsImg extends ArrayAdapter<Total> {
    private Activity context;
    HttpURLConnection client = null;
    List<Total> clients;

    ImageView imageView;







    //String url="https://firebasestorage.googleapis.com/v0/b/uidesignbsteltromat.appspot.com/o/User_Images%2F313843?alt=media&token=2b043092-f79e-4d9c-a649-4cc1c8e6ad9b";
    //String url="";




    public ViewClientCallsImg(Activity context, List<Total> clients) {
        super(context, R.layout.activity_view_client_calls_img, clients);
        this.context = context;
        this.clients = clients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_view_client_calls_img, null, true);

        TextView textViewRegion = (TextView) listViewItem.findViewById(R.id.status);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.member_name);

        // TextView textViewAdd = (TextView) listViewItem.findViewById(R.id.textAdd);
        //TextView textViewCont = (TextView) listViewItem.findViewById(R.id.textCont);

        imageView = (ImageView) listViewItem.findViewById(R.id.profile_pic);




        //BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        //Bitmap bitmap = drawable.getBitmap();


        // String abc= Total.client_image_url;


        // loadImageFromUrl(url);






        //TextView textViewRegion=(TextView)listViewItem.findViewById(R.id.textRegion)
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);


        Total data = clients.get(position);
        //UserInformation data1=clients1.get(position);
        textViewName.setText(data.getClient());
        // textViewAdd.setText(data.getAddress());
        //textViewCont.setText(data.getContact());
        textViewRegion.setText(data.getDate());
        Picasso.with(context).load(data.getClient_image_url().toString()).into(imageView);
        // imageView.setImageBitmap(bitmap);


    /*try {
            URL url = new URL("https://firebasestorage.googleapis.com/v0/b/uidesignbsteltromat.appspot.com/o/User_Images%2F313843?alt=media&token=2b043092-f79e-4d9c-a649-4cc1c8e6ad9b");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            //network error/ tell the user
        }*/



        //  URL url = new URL("http://....");
        // Bitmap imageViewPic = BitmapFactory.decodeStream(url.openConnection().getInputStream());


        //textViewEmail.setText(data.getEmail());



        return listViewItem;
    }


 /*private void loadImageFromUrl(String url) {

        Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });




    }*/


}