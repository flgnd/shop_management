package com.example.shoppingjavaspringserver.model.request;

import com.example.shoppingjavaspringserver.entities.CardEntity;
import com.google.gson.Gson;
import lombok.Data;

@Data
public class CardRequest {
    int quantity;
    public CardEntity toEntity(){
        CardEntity cardEntity = new CardEntity();
        cardEntity.setQuantity(this.getQuantity());
        System.out.println(new Gson().toJson(cardEntity));
        return cardEntity;
    }
}
