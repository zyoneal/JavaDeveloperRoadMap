package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao;

import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Company;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions.DaoException;

import java.util.List;

public interface CompanyDao {

    void save(Company company) throws DaoException;

    List<Company> getAll() throws DaoException;

    Company getById(Long id) throws DaoException;

}
