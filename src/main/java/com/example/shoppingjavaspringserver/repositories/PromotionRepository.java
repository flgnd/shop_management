package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
}
