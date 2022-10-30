package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao;

import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Chat;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Company;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Profile;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.User;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.ConnectionBuilder.getConnection;


public class CompanyDaoImpl implements CompanyDao {

    public static final String INSERT_COMPANY = "INSERT INTO company (name) VALUES (?);";

    public static final String INSERT_USER = "INSERT INTO users (username, firstname, lastname, birth_date, company_id, profile_id) VALUES (?, ?, ?, ?, ?, ?);";

    public static final String INSERT_PROFILE = "INSERT INTO profile (street, language) VALUES (?, ?);";

    public static final String INSERT_СHAT = "INSERT INTO chat (name) VALUES (?);";

    public static final String INSERT_USERS_CHAT = "INSERT INTO users_chat (user_id, chat_id) VALUES (?, ?);";

    public static final String GET_COMPANY = "SELECT c.id as comp_id, c.name FROM company c;";

    public static final String GET_FULL_COMPANY = "SELECT c.id as comp_id, c.name, " +
            "u.id as user_id, " +
            "u.username, " +
            "u.firstname, " +
            "u.lastname, " +
            "u.birth_date, " +
            "u.company_id, " +
            "p.id as pr_id, " +
            "p.street, " +
            "p.language, " +
            "ch.id as chat_id, " +
            "ch.name as chat_name " +
            "FROM company c " +
            "inner join users u on c.id = u.company_id " +
            "inner join profile p on u.profile_id = p.id " +
            "inner join users_chat uc on uc.user_id = u.id " +
            "inner join chat ch on ch.id = uc.chat_id;";

    public static final String GET_FULL_COMPANY_BY_ID = "SELECT c.id as comp_id, c.name, " +
            "u.id as user_id, " +
            "u.username, " +
            "u.firstname, " +
            "u.lastname, " +
            "u.birth_date, " +
            "u.company_id, " +
            "p.id as pr_id, " +
            "p.street, " +
            "p.language, " +
            "ch.id as chat_id, " +
            "ch.name as chat_name " +
            "FROM company c " +
            "inner join users u on c.id = u.company_id " +
            "inner join profile p on u.profile_id = p.id " +
            "inner join users_chat uc on uc.user_id = u.id " +
            "inner join chat ch on ch.id = uc.chat_id " +
            "WHERE c.id = ?;";

    @Override
    public void save(Company company) throws DaoException {
        Long companyId = null;
        Long profileId = null;
        Long userId = null;
        Long chatId = null;
        try (
                Connection connection = getConnection();
                PreparedStatement companyStatement = connection.prepareStatement(INSERT_COMPANY, new String[]{"id"});
                PreparedStatement userStatement = connection.prepareStatement(INSERT_USER, new String[]{"id"});
                PreparedStatement profileStatement = connection.prepareStatement(INSERT_PROFILE, new String[]{"id"});
                PreparedStatement chatStatement = connection.prepareStatement(INSERT_СHAT, new String[]{"id"});
                PreparedStatement usersChatStatement = connection.prepareStatement(INSERT_USERS_CHAT);
        ) {
            connection.setAutoCommit(false);
            try {
                companyStatement.setString(1, company.getName());
                companyStatement.executeUpdate();
                for (User u : company.getUsers()) {
                    profileStatement.setString(1, u.getProfile().getStreet());
                    profileStatement.setString(2, u.getProfile().getLanguage());
                    profileStatement.executeUpdate();

                    userStatement.setString(1, u.getUsername());
                    userStatement.setString(2, u.getFirstname());
                    userStatement.setString(3, u.getLastname());
                    userStatement.setDate(4, Date.valueOf(u.getBirthDate()));

                    ResultSet generatedKeysCompany = companyStatement.getGeneratedKeys();
                    if (generatedKeysCompany.next()) {
                        companyId = generatedKeysCompany.getLong(1);
                    }

                    ResultSet generatedKeysProfile = profileStatement.getGeneratedKeys();
                    if (generatedKeysProfile.next()) {
                        profileId = generatedKeysProfile.getLong(1);
                    }

                    userStatement.setLong(5, companyId);
                    userStatement.setLong(6, profileId);
                    userStatement.executeUpdate();

                    ResultSet generatedKeysUser = userStatement.getGeneratedKeys();
                    if (generatedKeysUser.next()) {
                        userId = generatedKeysUser.getLong(1);
                    }
                    for (Chat c : u.getChats()) {
                        chatStatement.setString(1, c.getName());
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(
                                "select count(*) from chat where name = " + "'" + c.getName() + "'");
                        while (resultSet.next()) {
                            long aLong = resultSet.getLong(1);
                            if (aLong < 1) {
                                chatStatement.executeUpdate();
                                ResultSet generatedKeysChat = chatStatement.getGeneratedKeys();
                                if (generatedKeysChat.next()) {
                                    chatId = generatedKeysChat.getLong(1);
                                }
                                usersChatStatement.setLong(1, userId);
                                usersChatStatement.setLong(2, chatId);
                                usersChatStatement.executeUpdate();
                            }
                            if (aLong > 0) {
                                Statement statement2 = connection.createStatement();
                                ResultSet resultSet2 = statement2.executeQuery(
                                        "select id from chat where name = " + "'" + c.getName() + "'");
                                while (resultSet2.next()) {
                                    long oldChatId = resultSet2.getLong(1);
                                    usersChatStatement.setLong(1, userId);
                                    usersChatStatement.setLong(2, oldChatId);
                                    usersChatStatement.executeUpdate();
                                }
                            }
                        }
                    }
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Company> getAll() throws DaoException {
        List<Company> result = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_FULL_COMPANY);
                PreparedStatement company = connection.prepareStatement(GET_COMPANY);
        ) {
            ResultSet resultSet = company.executeQuery();
            while (resultSet.next()) {
                result.add(fillCompany(resultSet));
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Company optional = result.stream()
                        .filter(c -> {
                            try {
                                return c.getId() == rs.getLong("company_id");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            return false;
                        })
                        .findFirst().get();
                fillFullCompany(rs, optional, connection);
            }
            resultSet.close();
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    private void fillFullCompany(ResultSet rs, Company company, Connection connection) {
        try {
            User user = fillUser(rs, connection);
            if (!company.getUsers().contains(user)) {
                company.addUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Company fillCompany(ResultSet rs) throws SQLException {
        Long id = rs.getLong("comp_id");
        String name = rs.getString("name");
        return new Company(id, name);
    }

    private User fillUser(ResultSet rs, Connection connection) throws SQLException {
        Long id = rs.getLong("user_id");
        String username = rs.getString("username");
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        LocalDate birthDate = rs.getDate("birth_date").toLocalDate();
        Profile profile = fillProfile(rs, id);
        User user = new User(id, username, firstname, lastname, birthDate);
        user.setProfile(profile);
        user.setChats(findChatsByUserId(id, connection));
        return user;
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

    private Profile fillProfile(ResultSet rs, Long id) throws SQLException {
        String street = rs.getString("street");
        String language = rs.getString("language");
        return new Profile(id, street, language);
    }

    @Override
    public Company getById(Long id) throws DaoException {
        Company company = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_FULL_COMPANY_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (company == null) {
                    company = fillCompany(resultSet);
                }
                fillFullCompany(resultSet, company, connection);

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return company;
    }

}
