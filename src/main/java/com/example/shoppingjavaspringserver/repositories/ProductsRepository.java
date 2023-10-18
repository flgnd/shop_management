package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
    List<ProductsEntity> findByName(String name);
    @Query("SELECT u FROM ProductsEntity  u WHERE u.name = :name")
    ProductsEntity findByNameMethodPut(String name);
}
