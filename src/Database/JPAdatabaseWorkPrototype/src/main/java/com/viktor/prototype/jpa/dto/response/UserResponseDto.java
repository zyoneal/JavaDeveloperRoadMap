package com.viktor.prototype.jpa.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponseDto {

    private Long id;

    private String username;

    private String firstname;

    private String lastname;

    private LocalDate birthDate;

    private String companyName;

    private List<String> chatNames;

}
