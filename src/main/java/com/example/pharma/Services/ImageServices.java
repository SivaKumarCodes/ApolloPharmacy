package com.example.pharma.Services;

import com.example.pharma.Domain.ProductImages;
import com.example.pharma.Repository.ProductImagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices {
    ProductImagesRepository productImagesRepository;

    public ImageServices(ProductImagesRepository productImagesRepository) {
        this.productImagesRepository = productImagesRepository;
    }

}
