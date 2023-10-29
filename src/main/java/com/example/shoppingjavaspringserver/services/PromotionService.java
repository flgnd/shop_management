package com.example.shoppingjavaspringserver.services;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import com.example.shoppingjavaspringserver.entities.PromotionEntity;
import com.example.shoppingjavaspringserver.repositories.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class PromotionService {
        final PromotionRepository promotionRepository;

        public PromotionService(PromotionRepository promotionRepository) {
            this.promotionRepository = promotionRepository;
        }

        public PromotionEntity getById(int id) {
            return promotionRepository.findById(id).get();
        }

        public List<PromotionEntity> getAll() {
            return promotionRepository.findAll() ;

        }

    public PromotionEntity save(PromotionEntity updatePromotion) {
        return promotionRepository.save(updatePromotion);
    }

    public PromotionEntity findByCode(String code) {
        return promotionRepository.findByCodeMethodPut(code);
    }

    public PromotionEntity findByID(int id) {
            return  promotionRepository.findById(id).get();
    }
}
