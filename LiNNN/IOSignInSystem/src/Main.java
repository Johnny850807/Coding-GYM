import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        SignInSystem signInSystem = new SignInSystem();
        FileReaderAndWriter file = new FileReaderAndWriter();
        boolean Exit = false;

        while (!Exit) {
            System.out.println("(1) 登入 (2) 註冊帳密 (3) 離開:");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                        signInSystem.signIn();
                        Exit = true;
                    break;

                case 2:
                        signInSystem.signUp();
                    try {
                        file.writeUserInfoToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.print("Exit...");
                    Exit = true;
                    break;
            }
        }
    }
}
