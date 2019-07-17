package com.mind.bst;

public class Profile {





    //String data;
    String region;
    String name;
 String address;
    String contact;
    String email;
    String image_Url;

    public Profile (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getRegion() {
        return region;
    }



    public String getName() {
        return region;
    }
    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getImage_Url() {
        return image_Url;
    }


    public Profile(String data, String region,String name,String address, String contact,String email,String image_Url) {
        //this.data = data;

        this.name = name;
        this.region = region;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.image_Url=image_Url;
    }

}
