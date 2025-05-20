package com.chtrembl.petstore.product.repository;

import com.chtrembl.petstore.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE status = :status", nativeQuery = true)
    List<Product> findByStatus(@Param("status") String status);
}
