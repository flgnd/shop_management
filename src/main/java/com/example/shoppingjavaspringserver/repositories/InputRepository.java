package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<InputEntity, Integer> {
}
