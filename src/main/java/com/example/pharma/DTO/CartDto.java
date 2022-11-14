package com.example.pharma.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private Long userId;
    private Long productId;
}
