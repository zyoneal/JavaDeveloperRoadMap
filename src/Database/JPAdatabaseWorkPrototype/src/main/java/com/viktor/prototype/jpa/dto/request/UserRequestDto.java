package com.viktor.prototype.jpa.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDto {

    private String username;

    private String firstname;

    private String lastname;

    private LocalDate birthDate;

    private Long companyId;

    private Long profileId;

}
