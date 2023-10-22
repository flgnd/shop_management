package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity,Integer> {
}
