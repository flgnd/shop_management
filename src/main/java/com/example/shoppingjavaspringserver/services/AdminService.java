package com.example.shoppingjavaspringserver.services;
import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.example.shoppingjavaspringserver.model.request.AdminRequest;
import com.example.shoppingjavaspringserver.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminEntity getById(int id) {
        return adminRepository.findById(id).get();
    }

    public AdminEntity create(AdminRequest adminRequest) {
        return adminRepository.save(adminRequest.toEntity());
    }

    public AdminEntity updateAdmin(AdminEntity adminEntity) {
        return adminRepository.save(adminEntity);
    }

    public boolean deleteAdmin(int id) {
        try {
            adminRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
