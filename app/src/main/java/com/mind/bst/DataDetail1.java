package com.mind.bst;

public class DataDetail1 {





    //String data;
    //String city;
    //String name;
    String client_cont;
    String client_email;
    // String email;

    public DataDetail1 (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getClient_cont() {
        return client_cont;
    }



    public String getClient_email() {
        return client_email;
    }


   /* public String getEmail() {
        return email;
    }*/


    public DataDetail1(String data, String client_cont,String client_email) {
        //this.data = data;

        this.client_cont = client_cont;
        this.client_email = client_email;

    }
}
