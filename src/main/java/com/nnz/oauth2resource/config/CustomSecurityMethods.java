package com.nnz.oauth2resource.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Arrays;
import java.util.List;

public class CustomSecurityMethods {
    final Authentication authentication;
    public CustomSecurityMethods(Authentication authentication){
        this.authentication = authentication;
    }
    
    public boolean checkIss(){
        if(authentication instanceof JwtAuthenticationToken){
            JwtAuthenticationToken token = (JwtAuthenticationToken)authentication;
            return token.getToken().getClaim("iss").equals("https://nnz.com");
        }
        return false;
    }
    private JwtAuthenticationToken getToken(){
        return (JwtAuthenticationToken)authentication;
    }
    public boolean hasRole(String...role){
        if(!checkIss()){
            return false;
        }
        JwtAuthenticationToken token = getToken();
        List<String> roles = token.getToken().getClaimAsStringList("roles");
        return roles.containsAll(Arrays.asList(role));
    }
    public boolean hasAnyRole(String...roles){
        if(!checkIss()){
            return false;
        }
        JwtAuthenticationToken token = getToken();
        List<String> tokenRoles = token.getToken().getClaimAsStringList("roles");
        for(String role : roles){
            if(tokenRoles.contains(role)){
                return true;
            }
        }
        return false;
    }
}
