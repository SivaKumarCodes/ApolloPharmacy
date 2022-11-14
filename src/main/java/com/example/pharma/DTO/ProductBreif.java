package com.example.pharma.DTO;

import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.ProductImages;
import com.example.pharma.Domain.Variant;
import lombok.Data;

import java.util.List;

@Data
public class ProductBreif {
    private final String title;
    private final Long id;
    private final String image;
    private final int price;

    public ProductBreif(Product p){
        this.title = p.getTitle();
        List<ProductImages> imageList = p.getImages();
        this.image = imageList.get(0).getUrl();
        this.id = p.getId();
        List<Variant> variants = p.getVariants();
        this.price = variants.get(0).getPrice();
    }
}
