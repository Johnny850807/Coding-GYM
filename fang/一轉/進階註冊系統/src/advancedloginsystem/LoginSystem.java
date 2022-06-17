package advancedloginsystem;

import advancedloginsystem.execption.UserDuplicateException;
import advancedloginsystem.execption.UserNotFoundException;
import advancedloginsystem.operation.Exit;
import advancedloginsystem.operation.Login;
import advancedloginsystem.operation.Operation;
import advancedloginsystem.operation.SignUp;
import advancedloginsystem.user.UserData;

import java.io.IOException;
import java.util.Scanner;

public class LoginSystem {
    private final Operation[] operations;
    private final Scanner input;
    private final UserData userData;

    public LoginSystem() throws IOException {
        userData = new UserData();
        input = new Scanner(System.in);
        this.operations = new Operation[]{
                new Login(), new SignUp(), new Exit()
        };
    }

    private void userOperation(int choose, UserData userData) throws IOException {
        this.operations[choose].execute(userData);
    }

    public void start() throws IOException {
        while (true){
            System.out.println("(0) 登入 (1) 註冊帳密 (2) 離開:");
            int choose = input.nextInt();
            try {
                userOperation(choose, userData);
            }catch (UserNotFoundException | UserDuplicateException ex){
                System.out.println(ex.getMessage());
            }
        }
    }


}
