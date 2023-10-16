package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.OrdersEntity;
import com.example.shoppingjavaspringserver.model.request.OrdersRequest;
import com.example.shoppingjavaspringserver.services.OrdersService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrders(@PathVariable("id")int id){
        return new Gson().toJson(ordersService.getById(id));
    }
    @PostMapping("/orders")
    @ResponseBody
    public OrdersEntity createCustomer(@RequestBody OrdersRequest request){
        return ordersService.create(request);
    }
    @PutMapping("/orders")
    public OrdersEntity updateOrders(){
        return null;
    }
}
