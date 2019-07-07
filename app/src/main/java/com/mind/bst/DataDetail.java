package com.mind.bst;

public class DataDetail {





    // String data;
    String region;
    String name;
    String address;
    String contact;
    String email;

    public void data(){

    }

   /* public String getData() {
        return data;
    }*/

    public String getRegion() {
        return region;
    }



    public String getName() {
        return name;
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


    public DataDetail(String data, String region,String name,String address, String contact,String email) {
        //this.data = data;

        this.name = name;
        this.region = region;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }
}
