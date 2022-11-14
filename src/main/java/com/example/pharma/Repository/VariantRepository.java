package com.example.pharma.Repository;

import com.example.pharma.Domain.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant , Long> {
}
