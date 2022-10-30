package com.viktor.prototype.jpa.controller;

import com.viktor.prototype.jpa.dto.request.CompanyRequest;
import com.viktor.prototype.jpa.dto.response.CompanyResponseDto;
import com.viktor.prototype.jpa.entity.Company;
import com.viktor.prototype.jpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/addCompany")
    public ResponseEntity<Company> addCompany(
            @RequestBody final CompanyRequest companyRequest) {
        Company addCompany = companyService.addCompany(companyRequest);
        return new ResponseEntity<>(addCompany, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyResponseDto>> getCompanies() {
        List<CompanyResponseDto> companies = companyService.getCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyResponseDto> getCategory(@PathVariable final Long id) {
        CompanyResponseDto companyResponseDto = companyService.getCompanyById(id);
        return new ResponseEntity<>(companyResponseDto, HttpStatus.OK);
    }

}
