public class UserInfo {

    private String account;
    private String password;
    private String ID;

    public UserInfo(String account, String password, String ID) {
        this.account = account;
        this.password = password;
        this.ID = ID;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
