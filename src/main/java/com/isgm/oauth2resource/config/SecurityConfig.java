package com.isgm.oauth2resource.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = new JwtIssuerAuthenticationManagerResolver( "https://isgm2.com");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt();

    }
}
