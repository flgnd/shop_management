package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.example.shoppingjavaspringserver.model.request.ItemsRequest;
import com.example.shoppingjavaspringserver.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ItemsEntity> getByDiscount(int discount) {
        return itemsRepository.findByDiscount(discount);
    }

    public List<ItemsEntity> getByDoubleDiscount(int discount1, int discount2) {
        return itemsRepository.findItemsByDoubleDiscount(discount1,discount2);
    }

    public List<ItemsEntity> getAll() {
        return itemsRepository.findAll() ;
    }

    public List<ItemsEntity> getByPrice(int price1, int price2) {
        return itemsRepository.findItemsByPrice(price1 , price2);

    }

    public ItemsEntity findByID(int id) {
        return itemsRepository.findByIdOfMethodPut(id);
    }

    public ItemsEntity save(ItemsEntity updateItems) {

        return itemsRepository.save(updateItems);
    }
}