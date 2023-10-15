package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getByName(String name) {
        return customerRepository.findByName(name) ;
    }

    public CustomerEntity getById(int id){
        return customerRepository.findById(id).get();
    }

    public CustomerEntity create(CustomerRequest customerRequest){
        return customerRepository.save(customerRequest.toEntity());
    }

    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

    public List<CustomerEntity> getByNameEmail(String name,String email) {
        return customerRepository.findByNameEmail(name,email);
    }
}
