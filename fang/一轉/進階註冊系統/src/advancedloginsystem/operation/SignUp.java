package advancedloginsystem.operation;

import advancedloginsystem.execption.UserDuplicateException;
import advancedloginsystem.user.User;
import advancedloginsystem.user.UserData;

import java.io.IOException;

public class SignUp implements Operation {

    @Override
    public void execute(UserData userData) throws IOException {
        System.out.println("輸入暱稱:");
        String name = input.nextLine();
        System.out.println("輸入帳號:");
        String account = input.nextLine();
        System.out.println("輸入密碼:");
        String password = input.nextLine();
        int bound = userData.size();
        for (int i = 0; i < bound; i++) {
            User user = userData.getUser(i);
            if (account.equals(user.getAccount())) {
                throw new UserDuplicateException();
            }
        }

        userData.signUpUser(name,account,password);
        System.out.println("註冊成功");

    }
}
