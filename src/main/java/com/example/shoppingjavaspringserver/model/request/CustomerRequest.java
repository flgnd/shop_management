package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class CustomerRequest {
    String phone;
    String name;
    String email;
    String username ;
    String password ;

    public CustomerEntity toEntity(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(this.getName());
        customerEntity.setPhone(this.getPhone());
        customerEntity.setEmail(this.getEmail());
        customerEntity.setUsername(this.getUsername());
        customerEntity.setPassword(this.getPassword());
        System.out.println(new Gson().toJson(customerEntity));

        return customerEntity;
    }
}
