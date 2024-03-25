package com.demo.chat.controller;

import com.demo.chat.dto.LoginDto;
import com.demo.chat.dto.RegistrationDto;
import com.demo.chat.service.AuthService;
import com.demo.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    // private final UserService userService;
    private final AuthService authService;

    /*@PostMapping("/register")
    public ResponseEntity<?> register(RegistrationDto request){
        return userService.createNewUser(request);
    }*/

    @PostMapping("/login")
    public ResponseEntity<?> login(LoginDto request){
        return authService.login(request);
    }
}
