package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByName(String name);
    @Query("select u from CustomerEntity u where u.email = :email")
    CustomerEntity findByEmail(@Param("email") String email);

    @Query("SELECT u FROM CustomerEntity u WHERE u.username = :username")
    CustomerEntity findByUsername(@Param("username") String username);



}
