package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class CustomerRequest {
    int phoneNumber;
    String name;
    String email;

    public CustomerEntity toEntity(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(this.getName());
        customerEntity.setPhoneNumber(this.getPhoneNumber());
        customerEntity.setEmail(this.getEmail());
        System.out.println(new Gson().toJson(customerEntity));

        return customerEntity;
    }
}
