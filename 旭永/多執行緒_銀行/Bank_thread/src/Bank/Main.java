package Bank;

import User.User_A;
import User.User_B;
import User.User_C;
import User.User_D;
import User.User_E;

public class Main {

	public static void main(String[] args) {

		Bank bank=new Bank();
		
		
		
		

		new Thread(new User_A(bank)).start();
		new Thread(new User_B(bank)).start();
		new Thread(new User_C(bank)).start();
		new Thread(new User_D(bank)).start();
		new Thread(new User_E(bank)).start();
		
	}

}




