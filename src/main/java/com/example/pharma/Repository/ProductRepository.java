package com.example.pharma.Repository;

import com.example.pharma.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends  JpaRepository<Product , Long> {
    List<Product> findProductsByBrand(String brand);
    List<Product> findProductsByType(String type);
}
