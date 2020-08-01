import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)  {
        boolean status = false;
        do {
            try{
                Login.LoginResults(LoginAccount(),LoginPassword());
                status = true;
            }catch(AccountNotFoundException|PasswordNotFoundException|PairInfoNotFoundException e){
                System.out.println(e.getMessage());
            }
        }while(!status);
        System.out.println("登入成功");
    }

    public static String LoginAccount(){
        String account;
        do{
            System.out.println("請輸入帳號:");
            account = sc.nextLine();


        }while(account.length()==0);
        return account;
    }

    public static String LoginPassword(){
        String password;
        do{
            System.out.println("請輸入密碼:");
            password = sc.nextLine();


        }while(password.length()==0);
        return password;
    }
}


