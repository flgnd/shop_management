package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity getById(int id){
        return customerRepository.findById(id).get();
    }

    public CustomerEntity create(CustomerRequest customerRequest){
        return customerRepository.save(customerRequest.toEntity());
    }
}
