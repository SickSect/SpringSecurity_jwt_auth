package com.demo.chat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.lifetime}")
    private Duration duration;

    public String generateToken(UserDetails details){
        // 1 step create claims
        Map<String, Object> claims = new HashMap<>();
        // take roles from user details
        List<String> roles = details
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", roles);
        // create expiration time for token
        Date issued = new Date();
        Date expired = new Date(issued.getTime() + duration.toMillis());
        return Jwts
                .builder()
                .setIssuedAt(issued)
                .setExpiration(expired)
                .setClaims(claims)
                .setSubject(details.getUsername())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims getAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token){
        return getAllClaims(token)
                .getSubject();
    }

    public List<String> getRoles(String token){
        return getAllClaims(token)
                .get("roles", List.class);
    }
}
