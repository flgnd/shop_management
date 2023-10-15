package com.example.shoppingjavaspringserver.services;
import com.example.shoppingjavaspringserver.entities.OrdersEntity;
import com.example.shoppingjavaspringserver.model.request.OrdersRequest;
import com.example.shoppingjavaspringserver.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    final OrdersRepository ordersRepository;
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public OrdersEntity getById(int id){
        return ordersRepository.findById(id).get();
    }
    public OrdersEntity create(OrdersRequest ordersRequest){
        return ordersRepository.save(ordersRequest.toEntity());
    }
}
