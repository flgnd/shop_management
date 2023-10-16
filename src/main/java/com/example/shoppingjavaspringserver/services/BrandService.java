package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.repositories.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public BrandEntity getById(int id){
        return brandRepository.findById(id).get();
    }
    public BrandEntity create(BrandRequest brandRequest){
        return brandRepository.save(brandRequest.toEntity());
    }

}
