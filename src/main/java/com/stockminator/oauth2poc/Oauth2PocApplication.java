package com.stockminator.oauth2poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@SpringBootApplication
public class Oauth2PocApplication {
	public static void main(String[] args) {
		SpringApplication.run(Oauth2PocApplication.class, args);
	}
}
