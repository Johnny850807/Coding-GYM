import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    ;
    private static Login sys = new Login();

    public static void main(String[] args) {
        InputNumber();


    }

    public static void InputNumber() {
        int judement = 0;
        while (true) {
            System.out.println("(0) 登入 (1) 註冊帳密 (2) 離開:");
            int number = input.nextInt();
            judement = number;
            switch (number) {
                case 0:
                    login();
                    break;
                case 1:
                    register();
                    break;
                case 2:
                    exit();
                    break;
            }
        }
    }

    public static void login() {
        System.out.println("請輸入帳號");
        String account = input.next();

        System.out.println("請輸入密碼");
        String password = input.next();

        sys.login(account, password);

    }

    public static void register() {
        System.out.println("請輸入帳號");
        String account = input.next();

        System.out.println("請輸入密碼");
        String password = input.next();

        System.out.println("請輸入暱稱");
        String id = input.next();

        sys.register(account, password, id);
    }

    public static void exit() {
        System.out.println("系統關閉");
        System.exit(0);
    }
}
