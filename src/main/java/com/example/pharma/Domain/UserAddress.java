package com.example.pharma.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String doorno;
    private String building;
    private String street;
    private String area;
    private String city;
    private String state;
    private String receiverName;
    private String receiverPhoneNumber;
}
