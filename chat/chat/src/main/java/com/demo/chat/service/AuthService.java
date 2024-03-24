package com.demo.chat.service;

import com.demo.chat.dto.JwtRequestDto;
import com.demo.chat.dto.RegistrationDto;
import com.demo.chat.exception.AppError;
import com.demo.chat.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtils jwtUtils;
    private final UserService userService;
    public ResponseEntity<?>  createAuthToken(JwtRequestDto request) {

    }

    public ResponseEntity<?> createNewUser(RegistrationDto request){
        if(!request.getPassword().equals(request.getPasswordConfirmation()))
            return ResponseEntity.badRequest().body(new AppError("Password and password confirmation are not equals", HttpStatus.BAD_REQUEST.value()));
        if (userService.findByUsername(request.getUsername()).isPresent())
            return ResponseEntity.badRequest().body(new AppError("User already exists", HttpStatus.BAD_REQUEST.value()));
        
    }
}
