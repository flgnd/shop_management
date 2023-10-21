package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class ProductsRequest {
    String name;

    public ProductsEntity toEntity(){
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setName(this.getName());

        System.out.println(new Gson().toJson(productsEntity));

        return productsEntity;
    }
}
