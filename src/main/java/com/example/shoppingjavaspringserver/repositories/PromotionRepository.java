package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
    @Query("SELECT u FROM PromotionEntity  u WHERE u.code = :code")
    PromotionEntity findByCodeMethodPut(String code);

}
