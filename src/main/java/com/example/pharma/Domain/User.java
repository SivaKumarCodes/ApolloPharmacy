package com.example.pharma.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    private String fName;

    private String lName;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<Cart> cart;

    @OneToMany(mappedBy = "questioner" , fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "buyer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Order> order;

    private String role;

    @OneToMany(mappedBy = "reviewer" , fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Review> reviews;

    public User(String fName, String lName, String email, String password , String role) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
