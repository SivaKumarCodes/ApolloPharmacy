package com.example.pharma.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private  String fname;
    private   String lname;
    private   String email;
    private   String password;
}
