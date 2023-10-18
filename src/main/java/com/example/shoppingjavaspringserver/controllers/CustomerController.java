package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.services.CustomerService;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/findByID")
    @ResponseBody
    public String getCustomer(@RequestParam(value="id", required=true) int id){
        return new Gson().toJson(customerService.getById(id));
    }
    @GetMapping("customer/findByName")
    @ResponseBody
    public String getCustomer(@RequestParam(value="name", required=true) String name){
        return new Gson().toJson(customerService.getByName(name));
    }
    @GetMapping("customer/findByEmail")
    @ResponseBody
    public String getCustomerbyEmail(@RequestParam(value="email", required=true) String email){
        return new Gson().toJson(customerService.getByEmail(email));
    }
    @GetMapping("customer/getAll")
    @ResponseBody
    public String getALLCustomer(){
        return new Gson().toJson(customerService.getAll());
    }


    @PostMapping("/customer/creeat")
    @ResponseBody
    public CustomerEntity createCustomer(@RequestBody CustomerRequest request){
        return customerService.create(request);
    }

    @PutMapping("/customer/updateById/{id}")
    public CustomerEntity updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest){
        CustomerEntity updateCustomer = customerService.findById(id);
        updateCustomer.setName(customerRequest.getName());
        updateCustomer.setEmail(customerRequest.getEmail());
        updateCustomer.setPhone(customerRequest.getPhone());
        return customerService.save(updateCustomer) ;
    }
    @PutMapping("/customer/updateByUsername")
    public CustomerEntity updateCustomerByUsername(@RequestParam(value="username", required=true) String username ,@RequestBody CustomerRequest customerRequest) {
        CustomerEntity updateCustomer = customerService.findByUsername(username);
        updateCustomer.setName(customerRequest.getName());
        updateCustomer.setEmail(customerRequest.getEmail());
        updateCustomer.setPhone(customerRequest.getPhone());
        return customerService.save(updateCustomer) ;

    }
}
