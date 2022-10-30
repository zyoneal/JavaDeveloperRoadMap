package JavaCore.Optional;

public class Account {

    private String login;

    private String password;

    private String email;

    private Double balance;

    public Account(String login, String password, String email, Double balance) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static Account getAccount() {
        return new Account(getAccount().login, getAccount().password, getAccount().email, getAccount().balance);
    }

}
