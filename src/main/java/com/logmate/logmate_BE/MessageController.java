package com.logmate.logmate_BE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping
    public Message createMessage(@RequestBody MessagePostDTO request) {
        // DTO로부터 전달받은 문자열을 Message 엔티티에 담아 저장
        Message message = new Message(request.getContent());
        return messageRepository.save(message);
    }
}