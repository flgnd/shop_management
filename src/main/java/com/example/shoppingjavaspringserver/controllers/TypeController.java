package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.TypeEntity;
import com.example.shoppingjavaspringserver.model.request.TypeRequest;
import com.example.shoppingjavaspringserver.services.TypeService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypeController {
    final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @PostMapping("type")
    @ResponseBody
    public TypeEntity createType(@RequestBody TypeRequest typeRequest){
        return typeService.createType(typeRequest);
    }
    @PutMapping("type")
    @ResponseBody
    public boolean updateType(@RequestParam (value = "id",required = true) int id,@RequestBody TypeRequest typeRequest){
        TypeEntity typeEntity = typeService.findById(id);
        typeEntity.setName(typeRequest.getName());
        return typeService.updateType(typeEntity);
    }
    @DeleteMapping("type")
    @ResponseBody
    public void deleteTypeById(@RequestParam(value = "id",required = true)int id){
         typeService.deleteTypeById(id);
    }
    @GetMapping("type/{id}")
    @ResponseBody
    public String getTypeById(@PathVariable("id")int id){
        return new Gson().toJson(typeService.getTypeById(id));
    }
}
