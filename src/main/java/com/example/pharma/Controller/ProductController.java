package com.example.pharma.Controller;

import com.example.pharma.DTO.Id;
import com.example.pharma.DTO.ProductBreif;
import com.example.pharma.DTO.ProductDto;
import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.Variant;
import com.example.pharma.Repository.ProductRepository;
import com.example.pharma.Services.ProductServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    private final ProductRepository productRepository;

    //public routes
    @GetMapping("/products")
    List<ProductDto> all(){
        return productServices.findall()
                .stream()
                .map(ProductDto::EntityToDTO)
                .toList();
    }


    @GetMapping("/variants")
    List<Variant> getVariant(@RequestBody Id id){
        return productServices.
                getVariantsByProductid(id.getId());
    }

    @PostMapping("/product")
    ProductDto getProduct(@RequestBody Id id){
        Product p =  productRepository
                .findById(id.getId())
                .orElseThrow(null);
        return ProductDto.EntityToDTO(p);
    }

    @CrossOrigin
    @PostMapping("/getBrandProductsBreif")
    List<ProductBreif> getBrandProductsBreif (@RequestBody Brand brand){
        return productRepository
                .findProductsByBrand(brand.getName())
                .stream()
                .map(ProductBreif::new)
                .toList();
    }

    @PostMapping("/getProductsByType")
    List<ProductBreif> getProductsByType(@RequestBody Type type ){
        return productRepository
                .findProductsByType(type.getName())
                .stream()
                .map(ProductBreif::new)
                .toList();
    }

    /**********
     * Admin Routes
     * *********
     */

    //addproduct
    @PostMapping("/addproduct")
    ProductDto addProduct(@RequestBody Product product){
        Product saved =  productServices.save(product);
        return  ProductDto.EntityToDTO(saved);
    }

}
@Data
class Brand{
    private String name;
}

@Data
class Type{
    private String name;
}
