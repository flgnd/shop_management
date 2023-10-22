package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.SizeEntity;
import com.example.shoppingjavaspringserver.model.request.SizeRequest;
import com.example.shoppingjavaspringserver.services.SizeService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class SizeController {
    final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @PostMapping("size")
    @ResponseBody
    public SizeEntity createSize(@RequestBody SizeRequest sizeRequest) {
        return sizeService.create(sizeRequest);
    }

    @PutMapping("size")
    @ResponseBody
    public SizeEntity updateSizeByName(@RequestParam(value = "name", required = true) String name, @RequestBody SizeRequest sizeRequest) {
        SizeEntity sizeEntity = sizeService.findByName(name);
        sizeEntity.setName(sizeRequest.getName());
        return sizeService.updateSizeByName(sizeEntity);
    }

    @DeleteMapping("size")
    @ResponseBody
    public boolean deleteSize(@RequestParam(value = "name",required = true) String name) {
        SizeEntity sizeEntity = sizeService.findByName(name);
        return sizeService.deleteSize(sizeEntity);
    }
    @GetMapping("/size/{id}")
    @ResponseBody
    public String getSize(@PathVariable("id")int id){
        return new Gson().toJson(sizeService.getById(id));
    }

}


