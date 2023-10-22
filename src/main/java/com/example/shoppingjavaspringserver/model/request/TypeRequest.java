package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.TypeEntity;
import lombok.Data;

@Data
public class TypeRequest {
    String name;
    public TypeEntity toEntity(){
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setName(this.getName());
        return  typeEntity;
    }
}

