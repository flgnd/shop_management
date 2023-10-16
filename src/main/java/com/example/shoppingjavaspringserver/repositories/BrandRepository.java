package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {
}
