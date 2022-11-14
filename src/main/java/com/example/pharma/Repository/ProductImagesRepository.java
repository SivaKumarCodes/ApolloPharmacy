package com.example.pharma.Repository;

import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages , Long> {
    public List<ProductImages> findAllByProduct(Product p);
}
