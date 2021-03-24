package com.stockminator.oauth2poc;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
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
//                .pathMatchers(HttpMethod.GET, "/hello/**").hasAuthority("resource_access_stockminator_roles_admin")
                .pathMatchers(HttpMethod.GET, "/hello/**").hasAuthority("ROLE_ADMIN")
//                .pathMatchers(HttpMethod.POST, "/foos").hasAuthority("SCOPE_write")
                .pathMatchers(HttpMethod.GET, "/bello/**").hasAuthority("ROLE_USER")
                .anyExchange().permitAll()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .csrf().disable()
                .build();
    }
}
