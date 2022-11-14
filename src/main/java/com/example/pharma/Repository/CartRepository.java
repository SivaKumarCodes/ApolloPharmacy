package com.example.pharma.Repository;


import com.example.pharma.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart , Long> {
}
