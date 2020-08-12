package view.status;

import controller.EcommerceController;
import view.View;

import java.util.Scanner;

public class EcommerceState implements State {
    private View view;
    private Scanner input = new Scanner(System.in);
    private EcommerceController ecommerceController;

    public EcommerceState(View view) {
        this.view = view;
        this.ecommerceController = view.getEcommerceController();
    }

    @Override
    public void launch() {
        System.out.println("(1)購買商品,(2)瀏覽自己擁有的商品,(3)瀏覽現有商品,(4)登出");

        switch (inputLimit(1, 4)) {
            case 1:
                System.out.println("請輸入想購買的產品編號及數量");
                ecommerceController.buyProducts(input.nextInt(), input.nextInt());
                break;
            case 2:
                ecommerceController.displayOwnProducts();
                break;
            case 3:
                ecommerceController.displayAllProducts();
                break;
            case 4:
                ecommerceController.signOut();
                view.setState(new LoginState(view));
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
