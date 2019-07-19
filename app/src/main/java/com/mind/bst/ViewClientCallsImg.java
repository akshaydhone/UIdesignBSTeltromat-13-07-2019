package com.mind.bst;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
     Button b1;




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
        b1=(Button)listViewItem.findViewById(R.id.b1);







     /* listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        });*/




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