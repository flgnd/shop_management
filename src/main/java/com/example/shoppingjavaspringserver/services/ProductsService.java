package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.model.request.ProductsRequest;
import com.example.shoppingjavaspringserver.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsEntity getById(int id){
        return productsRepository.findById(id).get();
    }


    public List<ProductsEntity> getByName(String name){
        return productsRepository.findByName(name);
    }

    public ProductsEntity create(ProductsRequest productsRequest){
        return productsRepository.save(productsRequest.toEntity());
    }

    public ProductsEntity findById(int id) {
        return productsRepository.findById(id).get();
    }

    public ProductsEntity save(ProductsRequest customerRequest) {
        return productsRepository.save(customerRequest.toEntity());
    }

    public ProductsEntity save(ProductsEntity updateCustomer) {
        return productsRepository.save(updateCustomer);
    }

    public List<ProductsEntity> getAll() {
        return productsRepository.findAll() ;
    }
}
