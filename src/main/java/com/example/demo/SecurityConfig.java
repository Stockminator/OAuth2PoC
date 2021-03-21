package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
//                .pathMatchers("/login/oauth2/*").permitAll()
                .pathMatchers(HttpMethod.GET, "/hello/**").hasAuthority("SCOPE_read")
//                .pathMatchers(HttpMethod.POST, "/foos").hasAuthority("SCOPE_write")
                .pathMatchers(HttpMethod.GET, "/bello/**").authenticated()
                .anyExchange().permitAll()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .csrf().disable()
                .build();
    }
}