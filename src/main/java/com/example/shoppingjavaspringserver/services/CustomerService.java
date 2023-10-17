package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity getById(int id){
        return customerRepository.findById(id).get();
    }


    public List<CustomerEntity> getByName(String name){
        return customerRepository.findByName(name);
    }
    public CustomerEntity getByEmail(String email){
        return customerRepository.myCustomQuery(email);
    }

    public CustomerEntity create(CustomerRequest customerRequest){
        return customerRepository.save(customerRequest.toEntity());
    }

    public CustomerEntity findById(int id) {
        return customerRepository.findById(id).get();
    }

//    public CustomerEntity save(CustomerRequest customerRequest) {
//        return customerRepository.save(customerRequest.toEntity());
//    }

    public CustomerEntity save(CustomerEntity updateCustomer) {
        return customerRepository.save(updateCustomer);
    }

    public List<CustomerEntity> getAll() {
        return customerRepository.findAll() ;
    }

    public CustomerEntity findByName(String name) {
        return customerRepository.findByNameOfMethodPut(name);
    }

//    public CustomerEntity findByName(String name) {
//
//        return customerRepository.findByName(name);
//    }
}