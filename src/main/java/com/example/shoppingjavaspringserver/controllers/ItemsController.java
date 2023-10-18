package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.example.shoppingjavaspringserver.model.request.ItemsRequest;
import com.example.shoppingjavaspringserver.services.ItemsService;
import com.example.shoppingjavaspringserver.services.InputService;
import com.example.shoppingjavaspringserver.model.request.InputRequest;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {
    final ItemsService itemsService;
    final InputService inputService ;

    public ItemsController(ItemsService itemsService, InputService inputService) {
        this.itemsService = itemsService;
        this.inputService = inputService;
    }

    @GetMapping("/items/{id}")
    @ResponseBody
    public String getItems(@PathVariable("id")int id){
        return new Gson().toJson(itemsService.getById(id));
    }
    @GetMapping("items/filterByDoubleDiscount")
    @ResponseBody
    public String getItemsByDoubleDiscount(@RequestParam(value="discount1", required=true) int discount1 , @RequestParam(value="discount2", required=true) int discount2){
        return new Gson().toJson(itemsService.getByDoubleDiscount(discount1, discount2));
    }
    @GetMapping("items/adc")
    @ResponseBody
    public String getItemsByPrice(@RequestParam(value="price1", required=true) int price1 , @RequestParam(value="price2", required=true) int price2){
        return new Gson().toJson(itemsService.getByPrice(price1, price2));
    }
    @GetMapping("items/filterByDiscount")
    @ResponseBody
    public String getItemsByDiscount(@RequestParam(value="discount", required=true) int discount){
        return new Gson().toJson(itemsService.getByDiscount(discount));
    }
    @PostMapping("/items/create")
    @ResponseBody
    public ItemsEntity createItems(@RequestBody ItemsRequest request){
        return itemsService.create(request);
    }

    @PutMapping("/items/updateItemsById")
    public ItemsEntity updateItemsById(@RequestParam(value="id", required=true) int id , @RequestBody ItemsRequest itemsRequest) {
        ItemsEntity updateItems = itemsService.findByID(id);
        updateItems.setDiscount(itemsRequest.getDiscount());
        updateItems.setStatus(itemsRequest.getStatus());
        updateItems.setPrice(itemsRequest.getPrice());
        return itemsService.save(updateItems) ;
    }
    @PutMapping("/items/updateItemQuantityById")
    public ItemsEntity updateQuantity(@RequestParam(value="id", required=true) int id ,  @RequestBody InputRequest inputRequest) {
        ItemsEntity updateItems = itemsService.findByID(id);
        updateItems.setQuantity(inputRequest.getInputQuantity() + updateItems.getQuantity());
        inputService.create(inputRequest);
        return itemsService.save(updateItems) ;
    }
    @GetMapping("items/findAll")
    @ResponseBody
    public String getAllItems(){
        return new Gson().toJson(itemsService.getAll());
    }

}
