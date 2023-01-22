package com.spring.web.flux.config;


import com.spring.web.flux.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class WebFluxRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> hello(GreetingHandler greetingHandler) {
        RequestPredicate route = GET("/")
                .and(accept(MediaType.APPLICATION_JSON));
        return RouterFunctions
                .route(route, greetingHandler::mainPage);
    }

    @Bean
    public RouterFunction<ServerResponse> helloThere(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/hello"),
                        greetingHandler::helloThere
                );
    }
}
