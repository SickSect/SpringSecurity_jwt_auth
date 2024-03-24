package com.demo.chat.dto;

import com.demo.chat.model.Role;
import lombok.Data;

import java.util.Collection;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
