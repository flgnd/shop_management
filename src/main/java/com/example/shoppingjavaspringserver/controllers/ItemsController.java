package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.ItemEntity;
import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.example.shoppingjavaspringserver.model.request.ItemRequest;
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
    @GetMapping("items/abd")
    @ResponseBody
    public String getItemsByDoubleDiscount(@RequestParam(value="discount1", required=true) int discount1 , @RequestParam(value="discount2", required=true) int discount2){
        return new Gson().toJson(itemsService.getByDoubleDiscount(discount1, discount2));
    }
    @GetMapping("items/adc")
    @ResponseBody
    public String getItemsByPrice(@RequestParam(value="price1", required=true) int price1 , @RequestParam(value="price2", required=true) int price2){
        return new Gson().toJson(itemsService.getByPrice(price1, price2));
    }
    @GetMapping("items/abe")
    @ResponseBody
    public String getItemsByDoubleDiscount(@RequestParam(value="discount", required=true) int discount){
        return new Gson().toJson(itemsService.getByDiscount(discount));
    }
    @PostMapping("/items")
    @ResponseBody
    public ItemsEntity createCustomer(@RequestBody ItemsRequest request){
        return itemsService.create(request);
    }

    @PutMapping("/item/abc")
    public ItemsEntity updateCustomerByName(@RequestParam(value="id", required=true) int id , @RequestBody ItemsRequest itemsRequest) {
        ItemsEntity updateItems = itemsService.findByID(id);
        updateItems.setQuantity(itemsRequest.getQuantity());
        updateItems.setDiscount(itemsRequest.getDiscount());
        return itemsService.save(updateItems) ;

    }

    @GetMapping("items/all")
    @ResponseBody
    public String getALLCustomer(){
        return new Gson().toJson(itemsService.getAll());
    }

}
