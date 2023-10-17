package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import com.example.shoppingjavaspringserver.model.request.CategoryRequest;
import com.example.shoppingjavaspringserver.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("category/post")
    @ResponseBody
    public CategoryEntity createCategory(@RequestBody CategoryRequest request){
        return categoryService.create(request);
    }
}
