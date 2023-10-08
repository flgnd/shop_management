package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.model.request.ProductsRequest;
import com.example.shoppingjavaspringserver.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsEntity getById(int id){
        return productsRepository.findById(id).get();
    }

    public ProductsEntity create(ProductsRequest productsRequest){
        return productsRepository.save(productsRequest.toEntity());
    }
}
