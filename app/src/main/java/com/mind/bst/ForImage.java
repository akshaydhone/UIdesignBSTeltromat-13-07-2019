package com.mind.bst;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class ForImage {





    //String data;
    //String city;
    //String name;
    String city;
    String engineer;


    static String client_image_url;


    // String email;




    public ForImage (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getCity() {
        return city;
    }

    public String getEngineer() {
        return engineer;
    }
//public  ImageView getClient_image(){return client_image;}



    public  String getClient_image_url() {
        return client_image_url;
    }




    public ForImage(String data, String city,String engineer,String client_image_url) {
        //this.data = data;

        this.city = city;
        this.engineer=engineer;

        this.client_image_url=client_image_url;

    }
}
