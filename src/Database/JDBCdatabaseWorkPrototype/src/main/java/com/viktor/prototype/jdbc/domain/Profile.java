package Database.JDBCdatabaseWorkPrototype.src.main.java.com.viktor.prototype.jdbc.domain;

public class Profile {

    private Long id;

    private String street;

    private String language;

    public Profile(){
    }

    public Profile(String street, String locale) {
        this.street = street;
        this.language = locale;
    }

    public Profile(Long id, String street, String language) {
        this.id = id;
        this.street = street;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

}
