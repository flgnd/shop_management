package com.example.shoppingjavaspringserver.repositories;
import com.example.shoppingjavaspringserver.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity>  findByName(String name);
    @Query("select u from CustomerEntity u where u.email = :email")
    CustomerEntity myCustomQuery(@Param("email") String email);


    @Query("select u from CustomerEntity u where u.email = :email and u.name = :name")
    List<CustomerEntity> findDoubleParam(@Param("name") String name, @Param("email") String email);
}
