
package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.InputEntity;
import com.google.gson.Gson;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InputRequest {
    int itemsid;
    int inputQuantity ;
    LocalDate date ;
    public InputEntity toEntity(){
        InputEntity inputEntity = new InputEntity();
        inputEntity.setItemsid(this.getItemsid());
        inputEntity.setInputQuantity(this.getInputQuantity());
        inputEntity.setDate(Date.valueOf(this.getDate()));
        System.out.println(new Gson().toJson(inputEntity));
        return inputEntity;
    }
}
