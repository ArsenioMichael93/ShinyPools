package com.example.shinypools.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.shinypools.database.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    public Product findById(@Param("id") Integer id);

    public Product findByName(@Param("productName") String productName);

}
