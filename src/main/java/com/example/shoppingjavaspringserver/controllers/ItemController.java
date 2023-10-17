package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.entities.ItemEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.model.request.ItemRequest;
import com.example.shoppingjavaspringserver.services.ItemService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{id}")
    @ResponseBody
    public String getItem(@PathVariable("id")int id){
        return new Gson().toJson(itemService.getById(id));
    }

    @PostMapping("/item")
    @ResponseBody
    public ItemEntity createItem(@RequestBody ItemRequest request){
        return itemService.create(request);
    }

    @PutMapping("/item/abc")
    public ItemEntity updateCustomerByName(@RequestParam(value="name", required=true) String name , @RequestBody ItemRequest itemRequest) {
        ItemEntity updateItem = itemService.findByName(name);
        updateItem.setName(itemRequest.getName());
        updateItem.setImage(itemRequest.getImage());
        return itemService.save(updateItem) ;

    }
}
