package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Integer> {
    List<ItemsEntity> findByDiscount(int discount);
    @Query("SELECT u FROM ItemsEntity u WHERE u.discount = :discount1  or u.discount = :discount2 ")
    List<ItemsEntity> findItemsByDoubleDiscount(@Param("discount1") Integer discount1 , @Param("discount2") Integer discount2 );

    List<ItemsEntity> findItemsByPrice(int price1, int price2);
}

