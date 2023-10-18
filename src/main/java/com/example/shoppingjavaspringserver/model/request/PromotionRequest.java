package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import com.google.gson.Gson;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class PromotionRequest {
    String code;
    int value ;
    int availability;
    LocalDate date ;
    String status ;

    public PromotionEntity toEntity(){
        PromotionEntity promotionEntity = new PromotionEntity();
        promotionEntity.setCode(this.getCode());
        promotionEntity.setValue(this.getValue());
        promotionEntity.setAvailability(this.getAvailability());
        promotionEntity.setStatus(this.getStatus());
        promotionEntity.setDate(Date.valueOf(this.getDate()));

        System.out.println(new Gson().toJson(promotionEntity));

        return promotionEntity;
    }
}
