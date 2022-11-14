package com.example.pharma.Repository;

import com.example.pharma.Domain.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ProductImages, Long> {
    List<ProductImages> findAllByProductId(Long id);
}
