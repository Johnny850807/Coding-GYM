package view.status;

import controller.EcommerceController;
import view.View;

import java.util.Scanner;

public class LoginState implements State {
    private View view;
    private Scanner input = new Scanner(System.in);
    private EcommerceController ecommerceController;

    public LoginState(View view) {
        this.view = view;
        ecommerceController = view.getEcommerceController();
    }

    @Override
    public void launch() {
        System.out.println("(1)註冊,(2)登入,(3)結束");

        switch (inputLimit(1, 3)) {
            case 1:
                System.out.println("請輸入註冊的帳號密碼");
                ecommerceController.register(input.next(), input.next());
                break;
            case 2:
                System.out.println("請輸入登入的帳號密碼");
                ecommerceController.login(input.next(), input.next());
                break;
            case 3:
                System.exit(0);
        }
    }

    public int inputLimit(int lowest, int highest) {
        int select;

        do {
            select = input.nextInt();

            if (select < lowest || select > highest) {
                System.out.println("輸入超過範圍，請重新輸入");
            }

        } while (select < lowest || select > highest);

        return select;
    }
}
