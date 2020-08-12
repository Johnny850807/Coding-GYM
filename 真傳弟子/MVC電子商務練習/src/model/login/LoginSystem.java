package model.login;

import model.login.dao.User;

public interface LoginSystem {
    User login(String account, String password) throws Exception;

    void register(String account, String password) throws Exception;

    void signOut();
}
