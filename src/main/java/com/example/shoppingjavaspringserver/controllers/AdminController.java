package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.AdminRequest;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.services.AdminService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/admin/{id}")
    @ResponseBody
    public String getAdmin(@PathVariable("id")int id){
        return new Gson().toJson(adminService.getById(id));
    }
    @PostMapping("/admin/customer")
    @ResponseBody
    public AdminEntity creatAdmin(@RequestBody AdminRequest request){
        return adminService.create(request);
    }
}
