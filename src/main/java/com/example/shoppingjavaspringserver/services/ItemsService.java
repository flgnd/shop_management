package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.example.shoppingjavaspringserver.model.request.ItemsRequest;
import com.example.shoppingjavaspringserver.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public ItemsEntity getById(int id){
        return itemsRepository.findById(id).get();
    }

    public ItemsEntity create(ItemsRequest itemsRequest){
        return itemsRepository.save(itemsRequest.toEntity());
    }
}