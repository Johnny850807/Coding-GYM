package SynchronizedTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
	
	public String bankName;
	public List<Account> accountList = new ArrayList();
	Random random = new Random();
	
	public Bank(String bankName) {
		this.bankName = bankName;
	}
	
	public void Withdraw(User user,int withdrawMoney) {
		int accountBalance = user.getAccount().getBalance();
		
		if(accountBalance >= withdrawMoney) {
			System.out.printf("�b��ثe���B:%d %s������B:%d�A "
					,accountBalance
					,Thread.currentThread().getName()
					,withdrawMoney);
			user.getAccount().setBalance(accountBalance - withdrawMoney);
			user.setMoney( user.getMoney() + withdrawMoney );
			
			System.out.println("�����b����B:" + user.getAccount().getBalance());
		}
		else {
//			System.out.printf("%s ������B:%d, �W�X�b��l�B:%d\n"
//					,Thread.currentThread().getName()
//					,money,account.getBalance());
		}
	}
	
	public void Deposit(User user,int depositMoney) {
		if(depositMoney < user.getMoney()) {
			System.out.printf("%s �ثe���Y���B:%d ,�s�ګ�b��l�B:%d\n"
					,user.getUserName()
					,user.getMoney()
					,user.getAccount().getBalance());
			
			user.setMoney(user.getMoney() - depositMoney);
			user.getAccount().setBalance( user.getAccount().getBalance() + depositMoney );
			System.out.printf("%s �ثe���Y���B:%d ,�s�ګ�b��l�B:%d\n"
					,user.userName
					,user.getMoney()
					,user.getAccount().getBalance());
		}
	}
	
	//copy paste
	synchronized public void DoTransactions(User user) throws Exception{
		int acctBalance = user.getAccount().getBalance();
		int userMoney = user.getMoney();
		
		while ( acctBalance > 0 ){
			if (random.nextBoolean() &&  userMoney != 0 ) {
				Deposit(user,random.nextInt(userMoney + 1));
			}
			else {
				Withdraw(user,random.nextInt(10000));
			}
		}
	}
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
}
