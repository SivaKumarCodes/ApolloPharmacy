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
public class Highlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String highlights;
    @ManyToOne(cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn()
    @JsonIgnore
    private Product product;

    public Highlight(String highlights , Product product) {
        this.highlights = highlights;
        this.product = product;
    }
}
