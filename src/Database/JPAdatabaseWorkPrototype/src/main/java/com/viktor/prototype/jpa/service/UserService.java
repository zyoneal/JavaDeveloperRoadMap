package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.request.UserRequestDto;
import com.viktor.prototype.jpa.dto.response.UserResponseDto;
import com.viktor.prototype.jpa.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponseDto addUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Long bookId);

    User getUser(Long bookId);

    List<UserResponseDto> getUsers();

    UserResponseDto deleteUser(Long bookId);

    UserResponseDto editUser(Long bookId, UserResponseDto userRequestDto);

    UserResponseDto addChatToUser(Long chatId, Long userId);

    UserResponseDto deleteChatFromUser(Long userId, Long chatId);

    UserResponseDto addProfileToUser(Long userId, Long profileId);

    UserResponseDto removeProfileFromUser(Long userId, Long profileId);

}
