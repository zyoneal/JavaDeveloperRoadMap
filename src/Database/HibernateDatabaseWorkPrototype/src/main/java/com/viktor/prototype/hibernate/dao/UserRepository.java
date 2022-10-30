package com.viktor.prototype.hibernate.dao;

import com.viktor.prototype.hibernate.entity.User;
import org.hibernate.Session;

public class UserRepository extends RepositoryBase<Long, User> {

    public UserRepository(Session session) {
        super(User.class, session);
    }

}
