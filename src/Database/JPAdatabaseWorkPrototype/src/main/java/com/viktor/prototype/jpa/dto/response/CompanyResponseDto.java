package com.viktor.prototype.jpa.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CompanyResponseDto {

    private Long id;

    private String name;

    private List<String> userUsernames;

}
