package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.request.ChatRequestDto;
import com.viktor.prototype.jpa.entity.Chat;
import com.viktor.prototype.jpa.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Transactional
    @Override
    public Chat addChat(ChatRequestDto chatRequestDto) {
        Chat chat = new Chat();
        chat.setName(chatRequestDto.getName());
        return chatRepository.save(chat);
    }

    @Override
    public Chat getChat(Long chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("couldn't find chat with id " + chatId));
    }

}
