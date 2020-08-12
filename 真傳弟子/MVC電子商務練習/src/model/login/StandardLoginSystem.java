package model.login;

import model.login.dao.UserRepository;
import model.login.dao.NormalUser;
import model.login.dao.User;
import exception.*;

public class StandardLoginSystem implements LoginSystem {
    UserRepository userRepository;

    public StandardLoginSystem(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String account, String password) throws Exception {
        User user = userRepository.getUser(account);

        if (user == null) {
            throw new AccountIsNotExistException();
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new PasswordIsErrorException();
            }
        }
    }

    @Override
    public void register(String account, String password) throws Exception {
        if (userRepository.getUser(account) != null) {
            throw new HaveSameAccountException();
        } else {
            userRepository.setUpNewUser(new NormalUser(account, password));
        }
    }

    @Override
    public void signOut() {
        userRepository.save();
    }
}
