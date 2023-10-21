package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {
    @Query("select c from CardEntity c where c.quantity = :quantity")
    CardEntity getByQuantity(int quantity);
}