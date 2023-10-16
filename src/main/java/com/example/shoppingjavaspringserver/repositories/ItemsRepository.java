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

    @Query("SELECT u FROM ItemsEntity u WHERE u.price BETWEEN :price1 AND :price2 ")
    List<ItemsEntity> findItemsByPrice(@Param("price1") Integer price1 , @Param("price2") Integer price2 );

    @Query("SELECT quantity FROM ItemsEntity ")
    List<ItemsEntity>findQuantity(@Param("price1") Integer price1 , @Param("price2") Integer price2 );

}

