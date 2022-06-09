package login;

import exceptions.AccountNotFoundException;
import exceptions.PairInfoNotFoundException;
import exceptions.PasswordNotFoundException;

import java.util.Scanner;

public class Login {
    private final Scanner input;
    private final User user;

    public Login() {
        input = new Scanner(System.in);
        user = new User();
    }

    public void start() {
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("輸入帳號:");
                String account = input.nextLine();
                System.out.println("輸入密碼:");
                String password = input.nextLine();
                checkUserAvailable(account, password);
                flag = true;
            } catch (AccountNotFoundException |
                    PairInfoNotFoundException |
                    PasswordNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void checkUserAvailable(String account, String password) {
        if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
            System.out.println("登入成功");
        } else if (!user.getAccount().equals(account) && user.getPassword().equals(password)) {
            throw new AccountNotFoundException("帳密不符合");
        } else if (user.getAccount().equals(account)) {
            throw new PasswordNotFoundException("密馬不符合");
        } else {
            throw new PairInfoNotFoundException("帳密不符合");
        }
    }
}
