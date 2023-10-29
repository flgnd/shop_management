package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.model.request.ProductsRequest;
import com.example.shoppingjavaspringserver.model.request.PromotionRequest;
import com.example.shoppingjavaspringserver.services.PromotionService;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @PutMapping("promotion/updateByCode")
    @ResponseBody
    public PromotionEntity updateByCode(@RequestParam(value="code", required=true) String code , @RequestBody PromotionRequest promotionRequest) {
        PromotionEntity updatePromotion = promotionService.findByCode(code);
        updatePromotion.setCode(promotionRequest.getCode());
        updatePromotion.setValue(promotionRequest.getValue());
        updatePromotion.setAvailability(promotionRequest.getAvailability());
        updatePromotion.setDate(Date.valueOf(promotionRequest.getDate()));
        return promotionService.save(updatePromotion) ;

    }
    @PutMapping("promotion/updateByID/{id}")
    @ResponseBody
    public PromotionEntity updateByCode(@PathVariable int id , @RequestBody PromotionRequest promotionRequest) {
        PromotionEntity updatePromotion = promotionService.findByID(id);
        updatePromotion.setCode(promotionRequest.getCode());
        updatePromotion.setValue(promotionRequest.getValue());
        updatePromotion.setAvailability(promotionRequest.getAvailability());
        updatePromotion.setDate(Date.valueOf(promotionRequest.getDate()));
        return promotionService.save(updatePromotion) ;

    }
}



