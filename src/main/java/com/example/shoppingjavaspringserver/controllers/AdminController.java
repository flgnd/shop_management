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
    @PostMapping("/admin")
    @ResponseBody
    public AdminEntity createAdmin(@RequestBody AdminRequest adminRequest){
        return adminService.create(adminRequest);
    }
    @PutMapping("admin")
    @ResponseBody
    public AdminEntity updateAdmin(@RequestParam(value= "id", required = true)int id,@RequestBody AdminRequest adminRequest){
        AdminEntity adminEntity = adminService.getById(id);
        adminEntity.setName(adminRequest.getName());
        adminEntity.setPhone(adminRequest.getPhone());
        adminEntity.setUserName(adminRequest.getUserName());
        adminEntity.setPassword(adminRequest.getPassword());
        adminEntity.setRegistrationDate(adminRequest.getRegistrationDate());
        return adminService.updateAdmin(adminEntity);
    }
    @DeleteMapping("admin")
    @ResponseBody
    public boolean deleteAdmin(  int id){
        AdminEntity adminEntity = adminService.getById(id);
        return adminService.deleteAdmin(id);
    }

}

