package com.example.projectexercise.apo.pojo.customer;

public class CustomerModel {
    private String customer_name;

    public CustomerModel(String customer_name){
        this.customer_name = customer_name;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name){
        this.customer_name = customer_name;
    }
}
