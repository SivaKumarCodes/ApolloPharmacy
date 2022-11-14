package com.example.pharma.DTO;

import com.example.pharma.Domain.Highlight;
import com.example.pharma.Domain.PackagingType;
import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.ProductImages;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.transaction.Transactional;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private PackagingType packagingType;
    private String type;
    private String brand;
    private List<ProductImages> images;
    @JsonManagedReference
    private List<Highlight> highlights;
    private int price;

    @Transactional
    public static ProductDto EntityToDTO(Product p){
        int price = p.getVariants().get(0).getPrice();
        return new ProductDto(p.getId() ,p.getTitle(),p.getPackagingType(),p.getType(),p.getBrand() , p.getImages() , p.getHighlights() , price);
    }
}
