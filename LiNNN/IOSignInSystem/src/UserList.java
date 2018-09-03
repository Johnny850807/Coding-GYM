import exception.AccountDuplicatedException;
import exception.UserSignInFailException;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public String checkSignIn(String account, String password){
        for (User user : users)
            if (user.getAccount().equals(account) && user.getPassword().equals(password))
                return "Welcome " + user.getName() + "!!";
            throw new UserSignInFailException();
    }

    public void checkAccountDuplicated(String account){
        for (User user : users)
            if (user.getAccount().equals(account))
                throw new AccountDuplicatedException();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
