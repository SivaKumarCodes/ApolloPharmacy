package com.example.pharma.Domain;
import com.example.pharma.DTO.CartDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Product product;

    public Cart(User u , Product p){
        this.user = u ;
        this.product = p;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return id.equals(cart.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
