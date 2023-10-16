package com.example.shoppingjavaspringserver.controllers;

import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.example.shoppingjavaspringserver.model.request.AdminRequest;
import com.example.shoppingjavaspringserver.services.AdminService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("admin/{id}")
    @ResponseBody
    public String getAdmin(@PathVariable("id")int id){
        return new Gson().toJson(adminService.getById(id));
    }
    public AdminEntity createAdmin(@RequestBody AdminRequest request){
        return adminService.create(request);
    }
    @PutMapping("admin")
    public AdminEntity updateAdmin(){
        return null;
    }

}

