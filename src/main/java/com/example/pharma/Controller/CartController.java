package com.example.pharma.Controller;

import com.example.pharma.DTO.CartDto;
import com.example.pharma.DTO.Id;
import com.example.pharma.Domain.Cart;
import com.example.pharma.Domain.Product;
import com.example.pharma.Domain.User;
import com.example.pharma.Repository.CartRepository;
import com.example.pharma.Repository.ProductRepository;
import com.example.pharma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class CartController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/addToCart")
    public List<Id> addToCart(@RequestBody CartDto cartDto){
        User u = userRepository.findUserById(cartDto.getUserId());
        Product p = productRepository.findById(cartDto.getProductId()).orElse(null);
        Cart c = new Cart(u , p);

        cartRepository.save(c);

        Set<Cart> cartList = userRepository.findUserById(cartDto.getUserId()).getCart();

        List<Id> products = new ArrayList<>();
        Iterator<Cart> cartIterator = cartList.iterator();
        while(cartIterator.hasNext()){
           products.add( new Id (cartIterator.next().getProduct().getId()));
        }
        return products;
    }

    @GetMapping("/getCart")
    public List<Id> getCart(@RequestBody Id id){
        User u = userRepository.findUserById(id.getId());

        Set<Cart> cartList = u.getCart();

        List<Id> products = new ArrayList<>();
        Iterator<Cart> cartIterator = cartList.iterator();
        while(cartIterator.hasNext()){
            products.add( new Id (cartIterator.next().getProduct().getId()));
        }
        return products;
    }

    }

