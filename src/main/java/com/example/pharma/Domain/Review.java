package com.example.pharma.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reveiw;
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(updatable = false)
    private User reviewer;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(updatable = false)
    private Product reviewedProduct;

    public Review(String reveiw, User reviewer, Product reviewedProduct) {
        this.reveiw = reveiw;
        this.reviewer = reviewer;
        this.reviewedProduct = reviewedProduct;
    }
}
