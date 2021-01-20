package com.nnz.oauth2resource.controllers;

import java.util.Map;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public Map<String, Object> testUrl(JwtAuthenticationToken token){
        System.out.println(token.getAuthorities());
        System.out.println(token.getName());
        System.out.println(token.getToken().getClaims());
        System.out.println(token.getDetails().getClass());
        return token.getTokenAttributes();
    }
}
