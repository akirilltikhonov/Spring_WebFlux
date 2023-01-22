package com.spring.web.flux.domain;

import org.springframework.data.annotation.Id;

public record Message(
        @Id
        Long id,
        String data
) {
}
