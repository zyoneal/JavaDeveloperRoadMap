package com.viktor.prototype.hibernate;

import com.viktor.prototype.hibernate.dao.ChatRepository;
import com.viktor.prototype.hibernate.dao.CompanyRepository;
import com.viktor.prototype.hibernate.entity.Chat;
import com.viktor.prototype.hibernate.entity.Company;
import com.viktor.prototype.hibernate.entity.Profile;
import com.viktor.prototype.hibernate.entity.User;
import com.viktor.prototype.hibernate.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()
        ) {

            Transaction transaction = session.beginTransaction();
            CompanyRepository companyRepository = new CompanyRepository(session);
            ChatRepository chatRepository = new ChatRepository(session);
            var google = Company.builder()
                    .name("GOOGLE")
                    .build();
            var profileIra = Profile.builder()
                    .street("POLSKA STREET")
                    .language("ua")
                    .build();
            var ira = User.builder()
                    .username("sveta@gmail.com")
                    .firstname("Sveta")
                    .lastname("Sereda")
                    .birthDate(LocalDate.of(2000, 2, 2))
                    .build();
            var profileViktor = Profile.builder()
                    .street("AVANGARDNA STREET")
                    .language("ua")
                    .build();

            var viktor = User.builder()
                    .username("viktor.piven@gmail.com")
                    .firstname("Viktor")
                    .lastname("Piven")
                    .birthDate(LocalDate.of(2002, 5, 20))
                    .build();

            var javaChat = Chat.builder()
                    .name("java")
                    .build();

            try {
                chatRepository.save(javaChat);

                viktor.addChat(javaChat);
                ira.addChat(javaChat);


                ira.setProfile(profileIra);
                viktor.setProfile(profileViktor);

                google.addUser(ira);
                google.addUser(viktor);

                companyRepository.save(google);

                // Second company

                var eleks = Company.builder()
                        .name("ELEKS")
                        .build();

                var profileSveta = Profile.builder()
                        .street("NOVA STREET")
                        .language("ua")
                        .build();
                var sveta = User.builder()
                        .username("kira@gmail.com")
                        .firstname("Kira")
                        .lastname("Pshenichna")
                        .birthDate(LocalDate.of(2000, 2, 2))
                        .build();

                var profileAndry = Profile.builder()
                        .street("UJNA STREET")
                        .language("ua")
                        .build();
                var andry = User.builder()
                        .username("andrii.televan@gmail.com")
                        .firstname("Egor")
                        .lastname("Turin")
                        .birthDate(LocalDate.of(2002, 2, 10))
                        .build();

                var dmdev = Chat.builder()
                        .name("dmdev")
                        .build();
                chatRepository.save(dmdev);

                andry.addChat(dmdev);
                andry.addChat(javaChat);
                sveta.addChat(dmdev);

                sveta.setProfile(profileSveta);
                andry.setProfile(profileAndry);

                eleks.addUser(sveta);
                eleks.addUser(andry);

                companyRepository.save(eleks);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
            //=====TEST=====

            List<Company> all = companyRepository.findAll();
            all.forEach(System.out::println);
        }
    }

}
