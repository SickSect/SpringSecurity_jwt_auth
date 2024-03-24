package com.demo.chat.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;
}
