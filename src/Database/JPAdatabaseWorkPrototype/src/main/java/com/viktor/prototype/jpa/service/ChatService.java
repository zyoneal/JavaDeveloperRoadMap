package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.request.ChatRequestDto;
import com.viktor.prototype.jpa.entity.Chat;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    Chat addChat(ChatRequestDto chatRequestDto);

    Chat getChat(Long chatId);

}
