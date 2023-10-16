package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.repositories.BrandRepository;
import lombok.Data;

@Data
public class BrandRequest {
    String name;
    String brandName;
    int totalQuantity;
    public BrandEntity toEntity(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName(this.getName());
        brandEntity.setBrandName(this.getBrandName());
        brandEntity.setTotalQuantity(this.getTotalQuantity());
        return brandEntity;
    }
}
