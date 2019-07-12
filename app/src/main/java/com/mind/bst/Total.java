package com.mind.bst;

public class Total {





    //String data;
    //String city;
    //String name;
    String city;
    String engineer;
    String client;
    String client_add;
    String client_cont;
    String client_email;
    String date;
    String time;
    String product_serial_no;
    String nature_of_complaint;
    String details_of_complaint;
    String engineer_observation;
    String client_remark;
    String product_name;
    String status_of_complaint;
    String payment_via;
    String client_image_url;


    // String email;




    public Total (){

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




    public String getClient() {
        return client;
    }


    public String getClient_add() {
        return client_add;
    }


    public String getClient_cont() {
        return client_cont;
    }


    public String getClient_email() {
        return client_email;
    }


    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }


    public String getProduct_serial_no() {
        return product_serial_no;
    }

    public String getNature_of_complaint() {
        return nature_of_complaint;
    }

    public String getDetails_of_complaint() {
        return details_of_complaint;
    }

    public String getEngineer_observation() {
        return engineer_observation;
    }

    public String getClient_remark() {
        return client_remark;
    }

    public String getProduct_name() {
        return product_name;
    }
    public String getStatus_of_complaint() {
        return status_of_complaint;
    }
    public String getPayment_via() {
        return payment_via;
    }
    public String getClient_image_url() {
        return client_image_url;
    }



    public Total(String data, String city,String engineer,String client,String client_add,String client_cont,String client_email,String date,String time,String product_serial_no,String nature_of_complaint,String details_of_complaint,String engineer_observation,String client_remark,String product_name,String status_of_complaint,String payment_via,String client_image_url) {
        //this.data = data;

        this.city = city;
        this.engineer=engineer;
        this.client = client;
        this.client_add=client_add;
        this.client_cont=client_cont;
        this.client_email=client_email;
        this.date=date;
        this.time=time;
        this.product_serial_no=product_serial_no;
        this.nature_of_complaint=nature_of_complaint;
        this.details_of_complaint=details_of_complaint;
        this.engineer_observation=engineer_observation;
        this.client_remark=client_remark;
       this.product_name=product_name;
       this.status_of_complaint=status_of_complaint;
       this.payment_via=payment_via;
       this.client_image_url=client_image_url;

    }
}
