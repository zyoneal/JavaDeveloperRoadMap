package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao;

import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.User;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions.DaoException;

import java.util.List;

public interface UserDao {

    void save(User user) throws DaoException;

    List<User> getAll() throws DaoException;

    User getById(Long id) throws DaoException;

    void update(User user) throws DaoException;

    void deleteById(Long id) throws DaoException;

}
