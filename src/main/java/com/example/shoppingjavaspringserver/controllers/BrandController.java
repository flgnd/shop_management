package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.BrandEntity;

import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.services.BrandService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("brand/{id}")
    @ResponseBody
    public String getBrand(@PathVariable("id")int id){
        return new Gson().toJson(brandService.getById(id));
    }
    @PostMapping("brand")
    @ResponseBody
    public BrandEntity createBrand(@RequestBody BrandRequest request){
        return brandService.create(request);
    }
    @PutMapping("brand")
    @ResponseBody
    public BrandEntity updateBand(@RequestParam(value= "name", required = true)String name,@RequestBody BrandRequest request){
        BrandEntity updateBrandEntityName = brandService.findByName(name);

        updateBrandEntityName.setName(request.getName());
//        updateBrandEntityName.setTotalQuantity(request.getTotalQuantity());
//        updateBrandEntityName.setBrandName(request.getBrandName());

        return brandService.updateBrand(updateBrandEntityName);
    }
    @DeleteMapping("brand")
    @ResponseBody boolean deleteBrand(@RequestParam(value= "name", required = true)String name){
        BrandEntity updateBrandEntityName = brandService.findByName(name);
        return brandService.deleteBrand(updateBrandEntityName);
    }






}
