package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.CardEntity;
import com.example.shoppingjavaspringserver.model.request.CardRequest;
import com.example.shoppingjavaspringserver.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService    {
    final CardRepository cardRepository;
    public CardService(CardRepository cardRepository) {this.cardRepository = cardRepository; }
    public CardEntity getById(int id) {return cardRepository.findById(id).get(); }
    public  CardEntity create(CardRequest cardRequest){
        return cardRepository.save(cardRequest.toEntity());
    }
}
