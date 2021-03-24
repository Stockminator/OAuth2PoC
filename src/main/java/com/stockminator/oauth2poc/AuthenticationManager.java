package com.stockminator.oauth2poc;

import java.util.List;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import reactor.core.publisher.Mono;

//@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        try {
//            if (!jwtUtil.validateToken(authToken)) {
//                return Mono.empty();
//            }
//            Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
//            List<String> rolesMap = claims.get("role", List.class);
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            for (String rolemap : rolesMap) {
//                authorities.add(new SimpleGrantedAuthority(rolemap));
//            }
//            return Mono.just(new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities));
            return Mono.just(new UsernamePasswordAuthenticationToken("claims.getSubject()", null, List.of()));
        } catch (Exception e) {
            return Mono.empty();
        }
    }
}
