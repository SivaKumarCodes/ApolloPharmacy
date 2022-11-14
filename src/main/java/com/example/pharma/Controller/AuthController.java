package com.example.pharma.Controller;

import com.example.pharma.DTO.Email;
import com.example.pharma.DTO.Id;
import com.example.pharma.DTO.UserDto;
import com.example.pharma.DTO.UserDtoRole;
import com.example.pharma.Domain.User;
import com.example.pharma.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class AuthController {
    UserRepository userRepository;

    @PostMapping("/register")
    public Id register(@RequestBody UserDto details){
        User u = new User(details.getFname(), details.getLname(), details.getEmail(), details.getPassword(),"USER");
        User savedUser = userRepository.save(u);
        return new Id(savedUser.getId());
    }

    @GetMapping("/getUserDetails")
    public UserDtoRole getUserDetails(@RequestBody Email e){
        User u = userRepository.findUserByEmail(e.getEmail());
        return new UserDtoRole(u.getFName(),u.getLName(),u.getEmail(),u.getPassword(),u.getRole());
    }
}
