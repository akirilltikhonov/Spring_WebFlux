package com.spring.web.flux.service;

import com.spring.web.flux.domain.Message;
import com.spring.web.flux.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
