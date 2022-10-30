package com.viktor.prototype.jpa.controller;

import com.viktor.prototype.jpa.dto.request.ChatRequestDto;
import com.viktor.prototype.jpa.entity.Chat;
import com.viktor.prototype.jpa.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {


    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/addChat")
    public ResponseEntity<Chat> addChat(
            @RequestBody final ChatRequestDto chatRequestDto) {
        Chat addChat = chatService.addChat(chatRequestDto);
        return new ResponseEntity<>(addChat, HttpStatus.OK);
    }

}
