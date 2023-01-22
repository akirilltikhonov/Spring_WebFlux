package com.spring.web.flux.handler;

import com.spring.web.flux.dto.Message;
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
        Flux<Message> data = Flux.just(
                        "Spring Boot"
                        , "WebFlux"
                        , "Mustache"
                        , "Netty"
                        , "Gradle"
                )
                .skip(start)
                .take(count)
                .map(Message::new);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Message.class);
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
