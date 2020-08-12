package model.login.dao;

public interface UserRepository {
    User getUser(String account);

    void setUpNewUser(User user);

    void save();
}
