package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.util.JwtUtil;

@RestController 
@RequestMapping("/api") 
public class HelloController { 
 
    // Step 1: Generate Token 
	@PostMapping("/login") 
    public ResponseEntity<?> login(@RequestParam String username) { 
        String token = JwtUtil.generateToken(username); 
        return ResponseEntity.ok("Bearer " + token); 
    } 
 
    @GetMapping("/hello") 
    public ResponseEntity<?> hello(Authentication authentication) { 
        String username = authentication.getName(); 
        return ResponseEntity.ok("Hello, " + username + "! You are authenticated."); 
    }
}