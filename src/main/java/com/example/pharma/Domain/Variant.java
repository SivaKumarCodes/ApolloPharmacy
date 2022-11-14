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
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_size_generator"
    )
    private Long id;
    @Column(nullable = false)
    private int size;
    @Column(nullable = false)
    private int price;

    private boolean isAvailable;

    private int itemsAvailables;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(updatable = false)
    private Product product;

    public Variant(int size, int price, Product product) {
        this.size = size;
        this.price = price;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variant variant = (Variant) o;

        return id.equals(variant.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Variant{" +
                "variantId=" + id +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
