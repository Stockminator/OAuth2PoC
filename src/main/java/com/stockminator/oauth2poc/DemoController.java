package com.stockminator.oauth2poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class DemoController {
    @GetMapping(value = "/{id}")
    public Mono<Foo> findOne(@PathVariable Long id) {
        return Mono.just(new Foo(id, String.valueOf(id)));
    }

    @GetMapping(value = "/")
    public Flux<Foo> findAll() {
        return Flux.just(new Foo(1L, "1"), new Foo(2L, "2"));
    }
}
