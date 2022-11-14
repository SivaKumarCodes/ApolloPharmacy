package com.example.pharma.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String Url;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinColumn()
    private Product product;

    public ProductImages(String url, Product product) {
        Url = url;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductImages images = (ProductImages) o;

        return id.equals(images.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Images{" +
                "Id=" + id +
                ", Url='" + Url + '\'' +
                '}';
    }
}
