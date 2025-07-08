package com.iwillpinchu.gatewayserver.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/contactSupport")
    public Mono<String> contactSupport() {
        return Mono.just("An Error Occurred, Please try again later or contact support.");
    }
}
