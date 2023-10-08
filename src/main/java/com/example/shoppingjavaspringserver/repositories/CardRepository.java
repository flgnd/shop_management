package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {
}
