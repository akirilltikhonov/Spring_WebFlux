package com.spring.web.flux.handler;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> mainPage(ServerRequest serverRequest) {
        BodyInserter<String, ReactiveHttpOutputMessage> inserter = BodyInserters.fromValue(("Spring WebFlux Server"));
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(inserter);
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
