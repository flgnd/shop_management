package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.InputEntity;
import com.example.shoppingjavaspringserver.model.request.InputRequest;
import com.example.shoppingjavaspringserver.repositories.InputRepository;
import org.springframework.stereotype.Service;
@Service

public class InputService {
    final InputRepository inputRepository ;

    public InputService(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public InputEntity create(InputRequest inputRequest){
        return inputRepository.save(inputRequest.toEntity());
    }
}
