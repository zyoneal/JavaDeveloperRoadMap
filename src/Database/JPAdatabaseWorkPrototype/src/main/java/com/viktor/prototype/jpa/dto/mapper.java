package com.viktor.prototype.jpa.dto;

import com.viktor.prototype.jpa.dto.response.CompanyResponseDto;
import com.viktor.prototype.jpa.dto.response.UserResponseDto;
import com.viktor.prototype.jpa.entity.Chat;
import com.viktor.prototype.jpa.entity.Company;
import com.viktor.prototype.jpa.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class mapper {

    public static CompanyResponseDto companyToResponseDto(Company company) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setName(company.getName());
        List<User> users = company.getUsers();
        List<String> usernames = new ArrayList<>();
        for (User u : users) {
            usernames.add(u.getUsername());
        }
        companyResponseDto.setUserUsernames(usernames);
        return companyResponseDto;
    }

    public static UserResponseDto userToResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setFirstname(user.getFirstname());
        userResponseDto.setLastname(user.getLastname());
        userResponseDto.setBirthDate(user.getBirthDate());
        userResponseDto.setCompanyName(user.getCompany().getName());
        List<String> chatNames = new ArrayList<>();
        Set<Chat> chats = user.getChats();
        for (Chat chat : chats) {
            chatNames.add(chat.getName());
        }
        userResponseDto.setChatNames(chatNames);
        return userResponseDto;
    }

    public static List<UserResponseDto> usersToUserResponseDtos(List<User> users) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(userToResponseDto(user));
        }
        return userResponseDtos;
    }


    public static List<CompanyResponseDto> companiesToCompanyResponseDto(List<Company> companies) {
        List<CompanyResponseDto> companiesResponseDtos = new ArrayList<>();
        for (Company company : companies) {
            companiesResponseDtos.add(companyToResponseDto(company));
        }
        return companiesResponseDtos;
    }

}
