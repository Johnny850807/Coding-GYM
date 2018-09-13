import java.io.IOException;
import java.util.Scanner;

public class SignInSystem {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager = new UserManager();
    private FileRecorder fileRecorder;

    public SignInSystem(){
        fileRecorder = new FileRecorder(userManager);
        try {
            fileRecorder.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signIn(){
        System.out.println("請輸入帳號: ");
        String account = input.nextLine();
        System.out.println("請輸入密碼: ");
        String password = input.nextLine();

        System.out.println(userManager.checkSignIn(account, password));
    }

    public void signUp(){
        System.out.println("請輸入帳號: ");
        String account = input.nextLine();
        System.out.println("請輸入密碼: ");
        String password = input.nextLine();
        System.out.println("請輸入名稱: ");
        String name = input.nextLine();

        userManager.checkAccountDuplicated(account);
        userManager.addUser(new User(name, account, password));

        try {
            fileRecorder.writeUserInfoToFile();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
