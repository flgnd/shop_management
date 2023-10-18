package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    @Query ("SELECT b FROM CategoryEntity b WHERE b.name = :name")
    CategoryEntity findCategoryByName(String name);
    @Query("SELECT b FROM CategoryEntity b WHERE b.name = :name")
    List<CategoryEntity> getCategoryByName(String name);
}
