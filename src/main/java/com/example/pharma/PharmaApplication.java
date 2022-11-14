package com.example.pharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication()
public class PharmaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaApplication.class, args);
    }

}
