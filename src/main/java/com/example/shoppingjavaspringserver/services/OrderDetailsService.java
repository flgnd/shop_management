package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.repositories.OrderDetailsRepository;
public class OrderDetailsService {
    public static Object checkOutStock;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
    public OrderDetailsService checkOutStock(int id , int quantity) {
        return null ;
    }
}
