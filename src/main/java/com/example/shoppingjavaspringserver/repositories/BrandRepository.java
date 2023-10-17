package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {
    @Query("UPDATE BrandEntity b SET b.name = :name WHERE b.name = :name")
    BrandEntity putByName(@Param("name") String name);

    @Query("SELECT b from  BrandEntity b where  b.name = :name")
    BrandEntity findByName(@Param("name")String name);


}
