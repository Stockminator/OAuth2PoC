package com.stockminator.oauth2poc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.BaseStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;

@Configuration
public class FunctionalWebfluxRoutesConfig {
    @Bean
    RouterFunction<ServerResponse> getAllFoosRoute() {
        return RouterFunctions.route(RequestPredicates.GET("/hellofunc"),
                req -> ServerResponse.ok().body(Flux.just(new Foo(1L, "1"), new Foo(2L, "2")), Foo.class));
    }

    @Bean
    RouterFunction<ServerResponse> getFileLinesRoute() {
        return RouterFunctions.route(RequestPredicates.GET("/filelines"),
                req -> ServerResponse.ok().body(Flux.using(() -> Files.lines(Path.of("/Users/fschneider/playground/Oauth2PoC/src/main/resources/demo.txt")), Flux::fromStream, BaseStream::close), String.class));
    }
}
