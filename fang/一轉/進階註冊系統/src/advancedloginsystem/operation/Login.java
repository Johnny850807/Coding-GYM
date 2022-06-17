package advancedloginsystem.operation;

import advancedloginsystem.execption.UserNotFoundException;
import advancedloginsystem.user.User;
import advancedloginsystem.user.UserData;

public class Login implements Operation {

    @Override
    public void execute(UserData userData) {
        System.out.println("輸入帳號:");
        String account = input.nextLine();
        System.out.println("輸入密碼:");
        String password = input.nextLine();
        int bound = userData.size();
        for (int i = 0; i < bound; i++) {
            User user = userData.getUser(i);
            if (account.equals(user.getAccount())
                    && password.equals(user.getPassword())) {
                System.out.println("歡迎登入 !!" + user.getName());
                return;
            }
        }
        throw new UserNotFoundException();

    }
}
