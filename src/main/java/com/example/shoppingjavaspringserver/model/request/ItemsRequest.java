package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class ItemsRequest {
    int quantity;
    int discount;
    int price;
    String status;

    public ItemsEntity toEntity(){
        ItemsEntity itemsEntity = new ItemsEntity();
        itemsEntity.setQuantity(this.getQuantity());
        itemsEntity.setDiscount(this.getDiscount());
        itemsEntity.setPrice(this.getPrice());
        itemsEntity.setStatus(this.getStatus());
        System.out.println(new Gson().toJson(itemsEntity));

        return itemsEntity;
    }
}
