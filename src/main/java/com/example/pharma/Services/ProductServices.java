package com.example.pharma.Services;

import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.Variant;
import com.example.pharma.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findall(){
        return productRepository.findAll();
    }

    public Product save(Product p){
        return productRepository.save(p);
    }

    public Product findbyId(Long id){
        return productRepository.findById(id).get();
    }

    public List<Variant> getVariantsByProductid(Long id){
        return productRepository.findById(id).get().getVariants();
    }

}
