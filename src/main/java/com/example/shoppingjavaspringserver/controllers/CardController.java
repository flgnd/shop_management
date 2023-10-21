package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CardEntity;
import com.example.shoppingjavaspringserver.model.request.CardRequest;
import com.example.shoppingjavaspringserver.services.CardService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {
    final CardService cardService;

    public CardController(CardService cardService){this.cardService=cardService;}
    @GetMapping("/card/{id}")
    @ResponseBody
    public String getCard(@PathVariable("id")int id) {return new Gson().toJson(cardService.getById(id));}

    @PostMapping("card")
    @ResponseBody
    public CardEntity createCard(@RequestBody CardRequest request){
        return cardService.create(request);
    }
    @PutMapping("card")
    @ResponseBody
    public CardEntity updateCard(@RequestParam (value = "id", required = true) int id,@RequestBody CardRequest newQuantity)
    {
        CardEntity cardEntity = cardService.getById(id);
        cardEntity.setQuantity(newQuantity.getQuantity());
        return cardService.updateCard(cardEntity);
    }

    @GetMapping("/card/quantity")
    public String getCardQuantity(@RequestParam("quantity")int quantity) {
        return new Gson().toJson(cardService.getByQuantity(quantity));
    }
    @DeleteMapping("card")
    @ResponseBody
    public void deleteCard (@RequestParam(value = "id", required = true) int id)
    {
        cardService.deleteCard(id);
    }
}