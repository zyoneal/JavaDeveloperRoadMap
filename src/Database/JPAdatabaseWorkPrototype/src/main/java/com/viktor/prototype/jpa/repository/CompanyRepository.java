package com.viktor.prototype.jpa.repository;

import com.viktor.prototype.jpa.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
}
