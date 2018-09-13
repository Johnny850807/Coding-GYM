import exception.AccountDuplicatedException;
import exception.UserSignInFailException;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    public String checkSignIn(String account, String password){
        for (User user : users)
            if (user.getAccount().equals(account) && user.getPassword().equals(password))
                return user.toString();
            throw new UserSignInFailException();
    }

    public void checkAccountDuplicated(String account){
        for (User user : users)
            if (user.getAccount().equals(account))
                throw new AccountDuplicatedException();
    }

    public void addUser(User user){
        System.out.println(user.getAccount() + " " + user.getPassword());
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
