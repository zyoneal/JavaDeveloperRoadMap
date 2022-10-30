package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.mapper;
import com.viktor.prototype.jpa.dto.request.CompanyRequest;
import com.viktor.prototype.jpa.dto.response.CompanyResponseDto;
import com.viktor.prototype.jpa.entity.Company;
import com.viktor.prototype.jpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    @Override
    public Company addCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        return companyRepository.save(company);
    }

    @Override
    public List<CompanyResponseDto> getCompanies() {
        List<Company> collect = StreamSupport.stream(
                        companyRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
        return mapper.companiesToCompanyResponseDto(collect);
    }

    @Override
    public CompanyResponseDto getCompanyById(Long companyId) {
        Company company = getCompany(companyId);
        return mapper.companyToResponseDto(company);
    }

    @Override
    public Company getCompany(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("couldn't find company with id " + companyId));
    }

    @Override
    public Company deleteCompany(Long companyId) {
        return null;
    }

    @Override
    public Company editCompany(Long companyId, Company company) {
        return null;
    }

    @Override
    public Company addUserToCompany(Long companyId, Long userId) {
        return null;
    }

    @Override
    public Company deleteUserFromCompany(Long userId) {
        return null;
    }

}
