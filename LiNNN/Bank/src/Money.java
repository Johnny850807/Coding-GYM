import java.util.Scanner;

public class Money {
	
	Scanner input = new Scanner(System.in);
	Bank bank = new Bank();
	
	public void Count(){
		System.out.println("1.�s�� 2.����   0.Exit");
		int choice = input.nextInt();
		while(choice != 0) {
			
			System.out.println("-----------------------------------");
			switch(choice) {
			case 1:
				System.out.println("�b��l�B: " + bank.getMoney());
				System.out.print("�s�J���B:�@");
				double amount = input.nextDouble();
				bank.setMoney(bank.getMoney() + amount);
				System.out.println("�b����B: " + bank.getMoney());
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			case 2:
				System.out.println("�b��l�B: " + bank.getMoney());
				System.out.println("���ڪ��B: ");
				double withdraw = input.nextDouble();
				while( withdraw > bank.getMoney() ) {
						System.out.println("�l�B����");
						System.out.println("�п�J" + bank.getMoney() + "�������B");
						withdraw = input.nextDouble();
					}
				bank.setMoney(bank.getMoney() - withdraw);
				System.out.println("�b��l�B: " + bank.getMoney());
				System.out.println("-----------------------------------");
				System.out.println("");
				break;
			}
			System.out.println("1.�s�� 2.����   0.Exit");
			choice = input.nextInt();
	
		}
	}
}
