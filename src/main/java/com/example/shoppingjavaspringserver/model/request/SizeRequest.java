package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.SizeEntity;
import lombok.Data;

@Data
public class SizeRequest {
    String name;
    public SizeEntity toEntity(){
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setName(this.getName());
        return sizeEntity;
    }
}
