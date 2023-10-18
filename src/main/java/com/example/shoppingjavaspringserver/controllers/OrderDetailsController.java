package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.OrderDetailsEntity;
import com.example.shoppingjavaspringserver.model.request.OrderDetailsRequest;
import com.example.shoppingjavaspringserver.services.OrderDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {
    final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }


    @PostMapping("/orderdetails")
    @ResponseBody
    public OrderDetailsEntity createOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        return  orderDetailsService.createOrderDetails(orderDetailsRequest);
    }

}
