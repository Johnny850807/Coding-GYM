import java.util.Scanner;

public class Money {
	
	Scanner input = new Scanner(System.in);
	Bank bank = new Bank();
	
	public void Count(){
		System.out.println("1.存款 2.提款   0.Exit");
		int choice = input.nextInt();
		while(choice != 0) {
			
			System.out.println("-----------------------------------");
			switch(choice) {
			case 1:
				System.out.println("帳戶餘額: " + bank.getMoney());
				System.out.print("存入金額:　");
				double amount = input.nextDouble();
				bank.setMoney(bank.getMoney() + amount);
				System.out.println("帳戶金額: " + bank.getMoney());
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			case 2:
				System.out.println("帳戶餘額: " + bank.getMoney());
				System.out.println("提款金額: ");
				double withdraw = input.nextDouble();
				while( withdraw > bank.getMoney() ) {
						System.out.println("餘額不足");
						System.out.println("請輸入" + bank.getMoney() + "內的金額");
						withdraw = input.nextDouble();
					}
				bank.setMoney(bank.getMoney() - withdraw);
				System.out.println("帳戶餘額: " + bank.getMoney());
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			}
			System.out.println("1.存款 2.提款   0.Exit");
			choice = input.nextInt();
	
		}
	}
}
