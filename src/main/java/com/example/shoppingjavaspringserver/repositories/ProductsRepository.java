package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
    List<ProductsEntity> findByName(String name);

}
