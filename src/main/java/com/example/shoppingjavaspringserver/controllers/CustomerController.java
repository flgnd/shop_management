package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.services.CustomerService;
import com.google.gson.Gson;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CustomerEntity updateCustomer(@Parameter()){
        return null;
    }
    @GetMapping("/customer/nm")
    public String findByName(@RequestParam (value = "name",required = true) String name){
        return new Gson().toJson(customerService.getByName(name));
    }
    @GetMapping("customer/findAll")
    public String findAll(){
        return new Gson().toJson(customerService.getAll());
    }
    @GetMapping("" +
            "")
    public String findNameEmail(@RequestParam (value ="name",required = true) String name,@RequestParam (value = "email",required = true)String email){
        return new Gson().toJson(customerService.getByNameEmail(name,email));
    }
}
