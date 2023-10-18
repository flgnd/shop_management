package com.example.shoppingjavaspringserver;

import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setPhone("1");
        customerRequest.setName("Khoa Tran");
        customerRequest.setEmail("KhoaTran.nd1102@gmail.com");

        System.out.println(new Gson().toJson(customerRequest));
    }
}
