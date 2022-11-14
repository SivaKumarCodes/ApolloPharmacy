package com.example.pharma.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRole {
    private  String fname;
    private  String lname;
    private  String email;
    private  String password;
    private  String role;
}
