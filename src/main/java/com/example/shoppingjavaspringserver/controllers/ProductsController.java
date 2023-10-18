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

    @GetMapping("products/findByID")
    @ResponseBody
    public String getProducts(@RequestParam(value="id", required=true) int id){
        return new Gson().toJson(productsService.getById(id));
    }
    @GetMapping("products/findByName")
    @ResponseBody
    public String getProducts(@RequestParam(value="name", required=true) String name){
        return new Gson().toJson(productsService.getByName(name));
    }
    @GetMapping("products/getAll")
    @ResponseBody
    public String getAllProducts(){
        return new Gson().toJson(productsService.getAll());
    }

    @PostMapping("/products/creat")
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
    @PutMapping("/products/name")
    public ProductsEntity updateProducts(@RequestParam(value = "name") String name, @RequestBody ProductsRequest productsRequest){
        ProductsEntity updateProducts = productsService.findByNameMethodPut(name);
//                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateProducts.setName(productsRequest.getName());
        return productsService.save(updateProducts) ;
    }
}

