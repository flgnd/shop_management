package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.services.BrandService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("brand/get/{id}")
    @ResponseBody
    public String getBrand(@PathVariable("id")int id){
        return new Gson().toJson(brandService.getById(id));
    }
    @PostMapping("brand/post")
    @ResponseBody
    public BrandEntity createBrand(@RequestBody BrandRequest request){
        return brandService.create(request);
    }




}
