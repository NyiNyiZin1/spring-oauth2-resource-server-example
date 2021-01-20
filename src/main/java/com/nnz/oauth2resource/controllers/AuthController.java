package com.nnz.oauth2resource.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("#jwt.hasRole('SUPER_ADMIN')")
public class AuthController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello nyiizin!";
    }
}
