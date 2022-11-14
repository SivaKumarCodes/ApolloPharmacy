package com.example.pharma.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "product_sequence")
    private Long id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PackagingType packagingType;
    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Highlight> highlights;

    private String type;
    private String brand;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "product" , fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Variant> variants;

    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<ProductImages> images;

    @OneToMany(mappedBy = "reviewedProduct" , fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<Review> reviews;

    public Product(String title, PackagingType packagingType, String Type , String Brand) {
        this.title = title;
        this.packagingType = packagingType;
        this.type = Type;
        this.brand = Brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", packagingType=" + packagingType +
                ", highlights='" + highlights + '\'' +
                ", variants=" + variants +
                '}';
    }
}
