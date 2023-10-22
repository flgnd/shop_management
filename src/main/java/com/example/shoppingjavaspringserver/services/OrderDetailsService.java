package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.OrderDetailsEntity;
import com.example.shoppingjavaspringserver.model.request.OrderDetailsRequest;
import com.example.shoppingjavaspringserver.repositories.OrderDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }


    public OrderDetailsEntity createOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        return orderDetailsRepository.save(orderDetailsRequest.toEntity());
    }

    public OrderDetailsEntity findById(int id) {
        return orderDetailsRepository.findById(id).get();
    }

    public boolean updataOrderDetails(OrderDetailsEntity orderDetailsEntity) {
        try {
            orderDetailsRepository.save(orderDetailsEntity);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteOrderDetailsById(int id) {
        orderDetailsRepository.deleteById(id);
    }
    public OrderDetailsEntity getById(int id) {
        return orderDetailsRepository.findById(id).get();
    }

}

