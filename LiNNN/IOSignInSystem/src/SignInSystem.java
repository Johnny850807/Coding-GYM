import java.util.Scanner;

public class SignInSystem {
    private Scanner input = new Scanner(System.in);
    private UserList userList = new UserList();

    public void signIn(){
        System.out.println("請輸入帳號: ");
        String account = input.nextLine();
        System.out.println("請輸入密碼: ");
        String password = input.nextLine();

        System.out.println(userList.checkSignIn(account, password));
    }

    public void signUp(){
        System.out.println("請輸入帳號: ");
        String account = input.nextLine();
        System.out.println("請輸入密碼: ");
        String password = input.nextLine();
        System.out.println("請輸入名稱: ");
        String name = input.nextLine();

        userList.checkAccountDuplicated(account);
        userList.addUser(new User(name, account, password));
    }

}
