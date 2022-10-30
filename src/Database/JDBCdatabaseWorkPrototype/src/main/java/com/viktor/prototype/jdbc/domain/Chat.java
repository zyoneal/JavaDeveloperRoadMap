package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private Long id;

    private String name;

    private List<User> users = new ArrayList<>();

    public Chat(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Chat() {
    }

    public Chat(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
