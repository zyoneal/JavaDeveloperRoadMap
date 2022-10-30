package com.viktor.prototype.hibernate.dao;

import com.viktor.prototype.hibernate.entity.Company;
import org.hibernate.Session;


public class CompanyRepository extends RepositoryBase<Long, Company> {

    public CompanyRepository(Session session) {
        super(Company.class, session);
    }

}
