
package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.ItemEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class ItemRequest {
    String image;
    String name ;
    public ItemEntity toEntity(){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setImage(this.getImage());
        itemEntity.setName(this.getName());
        System.out.println(new Gson().toJson(itemEntity));

        return itemEntity;
    }
}
