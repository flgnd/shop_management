package com.example.shoppingjavaspringserver.controllers;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.model.request.ProductsRequest;
import com.example.shoppingjavaspringserver.services.ProductsService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String getCustomer(@PathVariable("id")int id){
        return new Gson().toJson(productsService.getById(id));
    }

    @PostMapping("/products")
    @ResponseBody
    public ProductsEntity createCustomer(@RequestBody ProductsRequest request){
        return productsService.create(request);
    }

    @PutMapping("/products")
    public ProductsEntity updateProducts(){
        return null;
    }
}
