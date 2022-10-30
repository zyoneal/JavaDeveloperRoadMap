package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc;

import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.CompanyDao;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.CompanyDaoImpl;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.UserDao;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.dao.UserDaoImpl;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Chat;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Company;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.Profile;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain.User;
import Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.exceptions.DaoException;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) throws DaoException {
        UserDao userDao = new UserDaoImpl();
        CompanyDao companyDao = new CompanyDaoImpl();
        var google = new Company("GOOGLE");
        var profileIra = new Profile("POLSKA STREET", "ua");

        var ira = new User(
                "sveta@gmail.com",
                "Sveta",
                "Sereda",
                LocalDate.of(2000, 2, 2)
        );
        var profileViktor = new Profile("AVANGARDNA STREET", "ua");

        var viktor = new User(
                "viktor.piven@gmail.com",
                "Viktor",
                "Piven",
                LocalDate.of(2002, 5, 20)
        );

        var javaChat = new Chat("java");
        viktor.addChat(javaChat);
        ira.addChat(javaChat);

        ira.setProfile(profileIra);
        viktor.setProfile(profileViktor);

        google.addUser(ira);
        google.addUser(viktor);

        companyDao.save(google);

        // Second company

        var eleks = new Company("ELEKS");
        var profileSveta = new Profile("NOVA STREET", "ua");

        var sveta = new User(
                "kira@gmail.com",
                "Kira",
                "Pshenichna",
                LocalDate.of(2000, 2, 2)
        );
        var profileAndry = new Profile("UJNA STREET", "ua");

        var andry = new User(
                "andrii.televan@gmail.com",
                "Egor",
                "Turin",
                LocalDate.of(2002, 2, 10)
        );

        var dmdev = new Chat("dmdev");
        andry.addChat(dmdev);
        andry.addChat(javaChat);
        sveta.addChat(dmdev);

        sveta.setProfile(profileSveta);
        andry.setProfile(profileAndry);

        eleks.addUser(sveta);
        eleks.addUser(andry);

        companyDao.save(eleks);

        //=========TEST==========
        System.out.println("GET USER BY ID");
        System.out.println(userDao.getById(2L));

        System.out.println("GET ALL COMPANIES");
        companyDao.getAll().forEach(System.out::println);

        System.out.println("======GET COMPANY BY ID======");
        System.out.println(companyDao.getById(2L));

        System.out.println("=======ALL USERS=======");
        List<User> all = userDao.getAll();
        all.stream().forEach(System.out::println);

        System.out.println("=======GET USER BY ID=======");
        System.out.println(userDao.getById(4L));
    }

}
