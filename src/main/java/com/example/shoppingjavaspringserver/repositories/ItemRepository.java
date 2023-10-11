package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
