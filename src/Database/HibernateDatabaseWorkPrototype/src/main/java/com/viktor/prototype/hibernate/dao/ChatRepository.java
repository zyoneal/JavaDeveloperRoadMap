package com.viktor.prototype.hibernate.dao;

import com.viktor.prototype.hibernate.entity.Chat;
import org.hibernate.Session;

public class ChatRepository extends RepositoryBase<Long, Chat> {

    public ChatRepository(Session session) {
        super(Chat.class, session);
    }

}
