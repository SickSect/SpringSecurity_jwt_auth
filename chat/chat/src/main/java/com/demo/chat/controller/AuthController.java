package com.demo.chat.controller;

import com.demo.chat.dto.LoginDto;
import com.demo.chat.dto.RegistrationDto;
import com.demo.chat.service.AuthService;
import com.demo.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    // private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDto request){
        return authService.createNewUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request){
        log.info(request.toString());
        return authService.login(request);
    }
}
