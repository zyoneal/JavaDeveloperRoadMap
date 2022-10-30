package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.request.CompanyRequest;
import com.viktor.prototype.jpa.dto.response.CompanyResponseDto;
import com.viktor.prototype.jpa.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    Company addCompany(CompanyRequest companyRequest);

    List<CompanyResponseDto> getCompanies();

    CompanyResponseDto getCompanyById(Long companyId);

    Company getCompany(Long companyId);

    Company deleteCompany(Long companyId);

    Company editCompany(Long companyId, Company company);

    Company addUserToCompany(Long companyId, Long userId);

    Company deleteUserFromCompany(Long userId);

}
