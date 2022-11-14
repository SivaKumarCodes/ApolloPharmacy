package com.example.pharma.DTO;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
