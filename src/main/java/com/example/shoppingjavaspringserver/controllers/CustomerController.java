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

    @GetMapping("customer/abc")
    @ResponseBody
    public String getCustomer(@RequestParam(value="id", required=true) int id){
        return new Gson().toJson(customerService.getById(id));
    }
    @GetMapping("customer/abd")
    @ResponseBody
    public String getCustomer(@RequestParam(value="name", required=true) String name){
        return new Gson().toJson(customerService.getByName(name));
    }
    @GetMapping("customer/abe")
    @ResponseBody
    public String getCustomerbyEmail(@RequestParam(value="email", required=true) String email){
        return new Gson().toJson(customerService.getByEmail(email));
    }
    @GetMapping("customer/all")
    @ResponseBody
    public String getALLCustomer(){
        return new Gson().toJson(customerService.getAll());
    }


    @PostMapping("/customer")
    @ResponseBody
    public CustomerEntity createCustomer(@RequestBody CustomerRequest request){
        return customerService.create(request);
    }

    @PutMapping("/customer/{id}")
    public CustomerEntity updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest){
        CustomerEntity updateCustomer = customerService.findById(id);
//                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateCustomer.setName(customerRequest.getName());

        return customerService.save(updateCustomer) ;
    }
    @PutMapping("/customer/ade")
    public CustomerEntity updateCustomerByName(@RequestParam(value="namex", required=true) String namex ,@RequestBody CustomerRequest customerRequest) {
        CustomerEntity updateByNameCustomer = customerService.findByName(namex);
        updateByNameCustomer.setName(customerRequest.getName());
        updateByNameCustomer.setEmail(customerRequest.getEmail());
        updateByNameCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        return customerService.save(updateByNameCustomer) ;

    }
}
