package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import com.example.shoppingjavaspringserver.entities.SizeEntity;
import com.example.shoppingjavaspringserver.model.request.SizeRequest;
import com.example.shoppingjavaspringserver.repositories.SizeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SizeService {
    final SizeRepository sizeRepository;

    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public SizeEntity create(SizeRequest sizeRequest) {
        return sizeRepository.save(sizeRequest.toEntity());
    }

    public SizeEntity findByName(String name) {
        return  sizeRepository.findSizeByName(name);
    }

    public SizeEntity updateSizeByName(SizeEntity sizeEntity) {
        return sizeRepository.save(sizeEntity);
    }

    public boolean deleteSize( SizeEntity sizeEntity) {
        try {
            sizeRepository.delete(sizeEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public SizeEntity getById(int id){

        return sizeRepository.findById(id).get();
    }
}
