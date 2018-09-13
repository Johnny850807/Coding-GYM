public class User {
    private String name;
    private String account;
    private String password;

    public User(String account, String password, String name) {
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Welcome " + name  + "!!";
    }
}
