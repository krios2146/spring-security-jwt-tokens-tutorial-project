package com.example.jwt_tokens.message;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(path = "/send/{id}")
    public String sendMessage(@PathVariable Long receiverId, @RequestBody String text, HttpServletRequest request) {
        return messageService.sendMessage(receiverId, text, request);
    }
}
