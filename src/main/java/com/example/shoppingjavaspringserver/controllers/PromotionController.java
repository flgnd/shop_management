package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import com.example.shoppingjavaspringserver.model.request.PromotionRequest;
import com.example.shoppingjavaspringserver.services.PromotionService;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromotionController {
    final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @GetMapping("promotion/findByID")
    @ResponseBody
    public String getPromotion(@RequestParam(value = "id", required = true) int id) {
        return new Gson().toJson(promotionService.getById(id));
    }
    @GetMapping("promotion/getAll")
    @ResponseBody
    public String getAllProducts(){
        return new Gson().toJson(promotionService.getAll());
    }
}



