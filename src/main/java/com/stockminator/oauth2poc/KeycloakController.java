package com.stockminator.oauth2poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/keycloak")
public class KeycloakController {

    @GetMapping(value = "/user")
    public Mono<String> getUser() {
        return Mono.just("Hello User");
    }

    @GetMapping(value = "/admin")
    public Mono<String> getAdmin() {
        return Mono.just("Hello Admin");
    }
}
