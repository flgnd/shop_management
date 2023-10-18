package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.OrdersEntity;
import com.google.gson.Gson;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class OrdersRequest {
    LocalDate date;
    String paymentMethod;
    String paymentDetails;
    public OrdersEntity toEntity(){
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setDate(Date.valueOf(this.getDate()));HHHHH
        ordersEntity.setPaymentMethod(this.getPaymentMethod());
        ordersEntity.setPaymentDetails(this.getPaymentDetails());
        System.out.println(new Gson().toJson(ordersEntity));
        return ordersEntity;
    }

}
