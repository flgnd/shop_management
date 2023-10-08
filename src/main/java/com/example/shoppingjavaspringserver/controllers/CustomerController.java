package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.services.CustomerService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public String getCustomer(@PathVariable("id")int id){
        return new Gson().toJson(customerService.getById(id));
    }

    @PostMapping("/customer")
    @ResponseBody
    public CustomerEntity createCustomer(@RequestBody CustomerRequest request){
        return customerService.create(request);
    }

    @PutMapping("/customer")
    public CustomerEntity updateCustomer(){
        return null;
    }
}
