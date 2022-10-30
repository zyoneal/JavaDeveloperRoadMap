package com.viktor.prototype.hibernate.util;

import com.viktor.prototype.hibernate.entity.Chat;
import com.viktor.prototype.hibernate.entity.Company;
import com.viktor.prototype.hibernate.entity.Profile;
import com.viktor.prototype.hibernate.entity.User;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Chat.class);
        configuration.configure();
        return configuration.buildSessionFactory();
    }

}
