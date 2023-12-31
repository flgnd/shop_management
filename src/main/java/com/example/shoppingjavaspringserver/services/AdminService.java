package com.example.shoppingjavaspringserver.services;
import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.model.request.AdminRequest;
import com.example.shoppingjavaspringserver.model.request.CustomerRequest;
import com.example.shoppingjavaspringserver.repositories.AdminRepository;
import com.example.shoppingjavaspringserver.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminEntity getById(int id){
        return adminRepository.findById(id).get();
    }

    public AdminEntity create(AdminRequest adminRequest){
        return adminRepository.save(adminRequest.toEntity());
    }
}
