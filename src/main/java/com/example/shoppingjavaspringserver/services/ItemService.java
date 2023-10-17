package com.example.shoppingjavaspringserver.services;
import com.example.shoppingjavaspringserver.entities.ItemEntity;
import com.example.shoppingjavaspringserver.model.request.ItemRequest;
import com.example.shoppingjavaspringserver.repositories.ItemRepository;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemEntity getById(int id){
        return itemRepository.findById(id).get();
    }

    public ItemEntity create(ItemRequest itemRequest){
        return itemRepository.save(itemRequest.toEntity());
    }
    public ItemEntity save(ItemEntity updateItem) {
        return itemRepository.save(updateItem);
    }
    public ItemEntity findByName(String name) {
        return itemRepository.findByNameOfMethodPut(name);
    }
}