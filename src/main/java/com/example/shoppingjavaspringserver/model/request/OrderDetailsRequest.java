package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.OrderDetailsEntity;
import lombok.Data;

@Data
public class OrderDetailsRequest {
    int quantity;
    int price;
    int total;
    public OrderDetailsEntity toEntity(){
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setQuantity(this.getQuantity());
        orderDetailsEntity.setPrice(this.getPrice());
        orderDetailsEntity.setTotal(this.getTotal());
        return orderDetailsEntity;

    }

}
