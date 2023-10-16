package com.example.shoppingjavaspringserver.repositories;

import com.example.shoppingjavaspringserver.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Integer> {

}
