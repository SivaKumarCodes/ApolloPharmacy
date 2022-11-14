package com.example.pharma.Repository;

import com.example.pharma.Domain.Highlight;
import com.example.pharma.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HighlightRepository extends JpaRepository<Highlight , Long> {
    public List<Highlight> findAllByProduct(Product product);
}
