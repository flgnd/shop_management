package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.TypeEntity;
import com.example.shoppingjavaspringserver.model.request.TypeRequest;
import com.example.shoppingjavaspringserver.repositories.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public TypeEntity createType(TypeRequest typeRequest) {
        return typeRepository.save(typeRequest.toEntity());
    }

    public TypeEntity findById(int id) {
        return typeRepository.findById(id).get();
    }

    public boolean updateType(TypeEntity typeEntity) {
        try {
            typeRepository.save(typeEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteTypeById(int id) {
        typeRepository.deleteById(id);
    }

    public TypeEntity getTypeById(int id) {
        return typeRepository.findById(id).get();
    }
}
