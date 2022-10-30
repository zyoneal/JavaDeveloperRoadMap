package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao;

import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Chat;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Profile;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.User;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.ConnectionBuilder.getConnection;

public class UserDaoImpl implements UserDao {

    public static final String INSERT_USER = "INSERT INTO users (username, firstname, lastname, birth_date) VALUES (?, ?, ?, ?);";

    public static final String GET_USER_BY_ID = "SELECT " +
            "u.id as user_id, " +
            "u.username, " +
            "u.firstname, " +
            "u.lastname, " +
            "u.birth_date, " +
            "p.id as pr_id, " +
            "p.street, " +
            "p.language, " +
            "ch.id as chat_id, " +
            "ch.name as chat_name, " +
            "uc.user_id as chat_user_id, " +
            "uc.chat_id as chat_chat_id " +
            "FROM company c " +
            "inner join users u on c.id = u.company_id " +
            "inner join profile p on u.profile_id = p.id " +
            "inner join users_chat uc on uc.user_id = u.id " +
            "inner join chat ch on ch.id = uc.chat_id " +
            "WHERE u.id = ?;";

    public static final String GET_USERS = "SELECT * FROM users;";

    public static final String DELETE_USER = "DELETE FROM users where id = ?;";

    public static final String UPDATE_USER = "UPDATE users SET " +
            "username = ?, " +
            "firstname = ?, " +
            "lastname = ?, " +
            "birth_date = ? " +
            "WHERE id = ?";

    public User getById(Long id) throws DaoException {
        User user = null;
        String query = "select * from users where id = ?;";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getDate("birth_date").toLocalDate()
                );
                Profile profile = findProfileByUserId(resultSet.getLong("id"), connection);
                user.setProfile(profile);
                List<Chat> chats = this.findChatsByUserId(resultSet.getLong("id"), connection);
                user.setChats(chats);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    private Profile findProfileByUserId(Long userId, Connection connection) throws SQLException {
        Profile profile = null;
        String query = "select * " +
                "from profile p " +
                "inner join users u on u.profile_id = p.id where u.id = ?;";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, userId);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String street = resultSet.getString("street");
            String language = resultSet.getString("language");
            profile = new Profile(id, street, language);
        }
        return profile;
    }

    private List<Chat> findChatsByUserId(Long userId, Connection connection) throws SQLException {
        List<Chat> chats = new ArrayList<>();
        String query = "select " +
                "ch.id as chat_id, " +
                "ch.name as chat_name " +
                "from users_chat uc " +
                "left join chat ch on ch.id = uc.chat_id " +
                "where uc.user_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, userId);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            chats.add(new Chat(resultSet.getLong("chat_id"), resultSet.getString("chat_name")));
        }
        return chats;
    }

    public List<User> getAll() throws DaoException {
        List<User> list = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getDate("birth_date").toLocalDate()
                );
                Profile profile = findProfileByUserId(user.getId(), connection);
                List<Chat> chats = findChatsByUserId(user.getId(), connection);
                user.setProfile(profile);
                user.setChats(chats);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return list;
    }

    public void save(User user) throws DaoException {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USER, new String[]{"id"})) {
            connection.setAutoCommit(false);
            try {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getFirstname());
                statement.setString(3, user.getLastname());
                statement.setDate(4, Date.valueOf(user.getBirthDate()));
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(User user) throws DaoException {
        User byId = getById(user.getId());
        if (byId == null) {
            throw new NoSuchElementException();
        } else {
            try (
                    Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement(UPDATE_USER, new String[]{"id"})) {
                connection.setAutoCommit(false);
                try {
                    statement.setString(1, user.getUsername());
                    statement.setString(2, user.getFirstname());
                    statement.setString(3, user.getLastname());
                    statement.setDate(4, Date.valueOf(user.getBirthDate()));
                    statement.setString(5, user.getUsername());
                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    throw e;
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    public void delete(User user) throws DaoException {
        if (getById(user.getId()) != null) {
            try (
                    Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement(DELETE_USER, new String[]{"username"})) {
                connection.setAutoCommit(false);
                try {
                    statement.setLong(1, user.getId());
                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    throw e;
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    public void deleteById(Long id) throws DaoException {
        if (getById(id) != null) {
            try (
                    Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement(DELETE_USER, new String[]{"id"})) {
                connection.setAutoCommit(false);
                try {
                    statement.setLong(1, id);
                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    throw e;
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

}
