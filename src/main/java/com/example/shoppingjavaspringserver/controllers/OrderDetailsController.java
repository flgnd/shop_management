package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.OrderDetailsEntity;
import com.example.shoppingjavaspringserver.model.request.OrderDetailsRequest;
import com.example.shoppingjavaspringserver.services.OrderDetailsService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailsController {
    final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }
    @PostMapping("orderdetails")
    @ResponseBody
    public OrderDetailsEntity createOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        return  orderDetailsService.createOrderDetails(orderDetailsRequest);
    }
    @PutMapping("orderdetails")
    @ResponseBody
    public boolean updateOrderDetails(@RequestParam(value = "id",required = true) int id,@RequestBody OrderDetailsRequest orderDetailsRequest){
        OrderDetailsEntity orderDetailsEntity = orderDetailsService.findById(id);
        orderDetailsEntity.setQuantity(orderDetailsRequest.getQuantity());
        orderDetailsEntity.setPrice(orderDetailsRequest.getPrice());
        orderDetailsEntity.setTotal(orderDetailsRequest.getTotal());
        return orderDetailsService.updataOrderDetails(orderDetailsEntity);
    }
    @DeleteMapping("orderdetails")
    @ResponseBody
    public void deleteOrderDetailsById(@RequestParam(value = "id",required = true)int id){
        orderDetailsService.deleteOrderDetailsById(id);
    }
    @GetMapping("orderdetails/{id}")
    @ResponseBody
    public String getOrderDetails(@PathVariable int id){
        return new Gson().toJson(orderDetailsService.getById(id));
    }
}
