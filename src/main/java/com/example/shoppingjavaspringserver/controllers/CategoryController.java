package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.model.request.CategoryRequest;
import com.example.shoppingjavaspringserver.services.CategoryService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("category")
    @ResponseBody
    public CategoryEntity createCategory(@RequestBody CategoryRequest request){
        return categoryService.create(request);
    }
    @PutMapping("category")
    @ResponseBody
    public CategoryEntity updateCategory(@RequestParam(value= "name", required = true)String name,@RequestBody BrandRequest request){
        CategoryEntity updateCategoryEntityName = categoryService.findCategoryByName(name);

        updateCategoryEntityName.setName(request.getName());
        return  categoryService.updateCategory(updateCategoryEntityName);
    }
//    @DeleteMapping("category/delete")
//    @ResponseBody
//    public  boolean deleteCategoryByName(@RequestParam(value = "name",required = true) String name){
//        CategoryEntity updateCategoryEntityName = categoryService.findCategoryByName(name);
//        return categoryService.deleteCategoryByName(name);
//    }
    @GetMapping("category")
    @ResponseBody
    public String getCategoryByName(@RequestParam(value= "name", required = true)String name){
        return new Gson().toJson(categoryService.getCategoryByName(name));
    }
    @DeleteMapping("category")
    @ResponseBody
    public boolean deleteCategoryById(@RequestParam(value = "id" ,required = true) int id){
        return  categoryService.deleteCategoryById(id);
    }


}
