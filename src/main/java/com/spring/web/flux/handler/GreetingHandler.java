package com.spring.web.flux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> mainPage(ServerRequest serverRequest) {
        Long start = serverRequest.queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);
        Long count = serverRequest.queryParam("count")
                .map(Long::valueOf)
                .orElse(5L);
        Flux<String> data = Flux.just(
                        "Spring Boot\n"
                        , "WebFlux\n"
                        , "Mustache\n"
                        , "Netty\n"
                        , "Gradle\n"
                )
                .skip(start)
                .take(count);
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(data, String.class);
    }

    public Mono<ServerResponse> helloThere(ServerRequest serverRequest) {
        String user = serverRequest.queryParam("user")
                .orElse("Stranger In The Night");
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .render("index", Map.of("user", user));
    }
}
