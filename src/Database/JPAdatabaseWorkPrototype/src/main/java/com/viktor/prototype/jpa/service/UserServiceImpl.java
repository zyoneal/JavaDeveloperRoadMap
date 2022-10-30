package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.mapper;
import com.viktor.prototype.jpa.dto.request.UserRequestDto;
import com.viktor.prototype.jpa.dto.response.UserResponseDto;
import com.viktor.prototype.jpa.entity.Chat;
import com.viktor.prototype.jpa.entity.Company;
import com.viktor.prototype.jpa.entity.Profile;
import com.viktor.prototype.jpa.entity.User;
import com.viktor.prototype.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final CompanyService companyService;

    private final ProfileService profileService;

    private final ChatService chatService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CompanyService companyService, ProfileService profileService, ChatService chatService) {
        this.userRepository = userRepository;
        this.companyService = companyService;
        this.profileService = profileService;
        this.chatService = chatService;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setBirthDate(userRequestDto.getBirthDate());

        if (userRequestDto.getProfileId() == null) {
            return mapper.userToResponseDto(userRepository.save(user));
        }
        Profile profile = profileService.getProfile(userRequestDto.getProfileId());
        user.setProfile(profile);

        if (userRequestDto.getCompanyId() == null) {
            throw new IllegalArgumentException("user at least one company");
        }
        Company company = companyService.getCompany(userRequestDto.getCompanyId());


        user.setCompany(company);
        User save = userRepository.save(user);
        return mapper.userToResponseDto(save);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = getUser(userId);
        return mapper.userToResponseDto(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("couldn't find user with id " + userId));
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return null;
    }

    @Override
    public UserResponseDto deleteUser(Long userId) {
        return null;
    }

    @Override
    public UserResponseDto editUser(Long userId, UserResponseDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto addChatToUser(Long chatId, Long userId) {
        User user = getUser(userId);
        Chat chat = chatService.getChat(chatId);
        if (chat.getUsers().contains(user)) {
            throw new IllegalArgumentException("this chat is already assigned to this user");
        }
        user.addChat(chat);
        chat.addUser(user);
        userRepository.save(user);
        return mapper.userToResponseDto(user);
    }

    @Override
    public UserResponseDto deleteChatFromUser(Long userId, Long chatId) {
        return null;
    }

    @Override
    public UserResponseDto addProfileToUser(Long userId, Long profileId) {
        return null;
    }

    @Override
    public UserResponseDto removeProfileFromUser(Long userId, Long profileId) {
        return null;
    }

}
