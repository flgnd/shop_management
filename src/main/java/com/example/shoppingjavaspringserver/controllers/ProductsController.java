package com.example.shoppingjavaspringserver.controllers;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
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

    @GetMapping("products/abc")
    @ResponseBody
    public String getProducts(@RequestParam(value="id", required=true) int id){
        return new Gson().toJson(productsService.getById(id));
    }
    @GetMapping("products/abd")
    @ResponseBody
    public String getProducts(@RequestParam(value="name", required=true) String name){
        return new Gson().toJson(productsService.getByName(name));
    }
    @GetMapping("products/all")
    @ResponseBody
    public String getALLProducts(){
        return new Gson().toJson(productsService.getAll());
    }

    @PostMapping("/products")
    @ResponseBody
    public ProductsEntity createProducts(@RequestBody ProductsRequest request){
        return productsService.create(request);
    }

    @PutMapping("/products/{id}")
    public ProductsEntity updateProducts(@PathVariable int id, @RequestBody ProductsRequest productsRequest){
        ProductsEntity updateProducts = productsService.findById(id);
//                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateProducts.setName(productsRequest.getName());

        return productsService.save(updateProducts) ;
    }
}

