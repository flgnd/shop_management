package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import lombok.Data;

@Data
public class CategoryRequest {
    String name;
    public CategoryEntity toEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(this.getName());
        return categoryEntity;
    }
}
