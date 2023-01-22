package com.spring.web.flux.controller;

import com.spring.web.flux.domain.Message;
import com.spring.web.flux.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller/")
@RequiredArgsConstructor
public class Controller {

    private final MessageService messageService;

    @GetMapping("get-messages")
    Flux<Message> getMessages(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "5") Long count
    ) {
        return messageService.getAllMessages();
    }

    @PostMapping("save-message")
    Mono<Message> saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }
}
