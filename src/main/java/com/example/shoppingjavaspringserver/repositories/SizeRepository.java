package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.SizeEntity;
import com.example.shoppingjavaspringserver.model.request.SizeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity,Integer> {
    @Query("SELECT e FROM SizeEntity e where e.name =:name")
    SizeEntity findSizeByName(String name);
}
