package advancedloginsystem.operation;

import advancedloginsystem.user.UserData;

public class Exit implements Operation{

    @Override
    public void execute(UserData userData) {
        System.out.println("系統關閉");
        System.exit(0);
    }
}
