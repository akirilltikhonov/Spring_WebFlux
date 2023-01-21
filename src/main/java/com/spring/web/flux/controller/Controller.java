package com.spring.web.flux.controller;

import com.spring.web.flux.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/controller/")
@RequiredArgsConstructor
public class Controller {

    @GetMapping("getStack")
    Flux<Message> getStack(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "5") Long count
    ) {
        return Flux.just(
                        "Spring Boot"
                        , "WebFlux"
                        , "Mustache"
                        , "Netty"
                        , "Gradle"
                )
                .skip(start)
                .take(count)
                .map(Message::new);
    }
}
