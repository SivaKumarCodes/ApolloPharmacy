package com.example.pharma.Controller;

import com.example.pharma.DTO.Id;
import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.ProductImages;
import com.example.pharma.Repository.ProductImagesRepository;
import com.example.pharma.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ProductImagesRepository productImagesRepository;
    private final ProductRepository productRepository;

    @GetMapping("/images")
    public ProductImages[] getAllImagesById(@RequestBody Id id) {
        Product p = productRepository.findById(id.getId()).orElseThrow();
        return productImagesRepository.findAllByProduct(p).toArray(new ProductImages[0]);
    }
}