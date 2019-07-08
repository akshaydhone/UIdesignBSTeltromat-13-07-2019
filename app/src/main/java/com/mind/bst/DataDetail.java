package com.mind.bst;

public class DataDetail {





    //String data;
    String city;
    String name;
    String client;
    String add;
  // String client_cont;
   //String client_email;
   // String client_cont;
    //String client_email;
   // String email;

    public DataDetail (){

    }

   /*public String getData() {
        return data;
    }*/

    public String getCity() {
        return city;
    }



    public String getName() {
        return name;
    }
    public String getClient() {
        return client;
    }

    public String getAdd() {
        return add;
    }

   /* public String getClient_cont() {
        return client_cont;
    }



    public String getClient_email() {
        return client_email;
    }*/



   /* public String getEmail() {
        return email;
    }*/


    public DataDetail(String data, String city,String name,String client, String add) {
        //this.data = data;

        this.name = name;
        this.city = city;
        this.client = client;
        this.add = add;
        //this.client_cont = client_cont;
        //this.client_email = client_email;
        //this.email = email;
    }
}
