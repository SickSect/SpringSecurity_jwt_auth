package com.demo.chat.service;

import com.demo.chat.dto.*;
import com.demo.chat.exception.AppError;
import com.demo.chat.model.User;
import com.demo.chat.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    public ResponseEntity<?> createNewUser(RegistrationDto request) {
        if(!request.getPassword().equals(request.getPasswordConfirmation()))
            return ResponseEntity.badRequest().body(new AppError("Password and password confirmation are not equals", HttpStatus.BAD_REQUEST.value()));
        if (userService.findByUsername(request.getUsername()).isPresent())
            return ResponseEntity.badRequest().body(new AppError("User already exists", HttpStatus.BAD_REQUEST.value()));
        User user = userService.createNewUser(request);
        return ResponseEntity.ok(new UserDto(user.getId(),
                user.getUsername(),
                user.getEmail()));
    }

    public ResponseEntity<?> login(LoginDto request){
        User loginUser = userService.findByUsername(request.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("User does not exist"));
        if (!encoder.matches(request.getPassword(), loginUser.getPassword()))
            return ResponseEntity.badRequest().body(new AppError("Wrong password", HttpStatus.BAD_REQUEST.value()));
        UserDetails details = userService.loadUserByUsername(request.getUsername());
        String token = jwtUtils.generateToken(details);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }


}
