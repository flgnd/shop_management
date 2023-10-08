package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.example.shoppingjavaspringserver.model.request.ItemsRequest;
import com.example.shoppingjavaspringserver.services.ItemsService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {
    final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items/{id}")
    @ResponseBody
    public String getItems(@PathVariable("id")int id){
        return new Gson().toJson(itemsService.getById(id));
    }

    @PostMapping("/items")
    @ResponseBody
    public ItemsEntity createCustomer(@RequestBody ItemsRequest request){
        return itemsService.create(request);
    }

    @PutMapping("/items")
    public ItemsEntity updateCustomer(){
        return null;
    }
}
