import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		Money money = new Money();
		Account account = new Account();
		
		account.SignUp();
		money.Count();
		
	}

}
