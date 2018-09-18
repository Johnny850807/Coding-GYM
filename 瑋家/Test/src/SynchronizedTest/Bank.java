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
			System.out.printf("帳戶目前金額:%d %s提領金額:%d， "
					,accountBalance
					,Thread.currentThread().getName()
					,withdrawMoney);
			user.getAccount().setBalance(accountBalance - withdrawMoney);
			user.setMoney( user.getMoney() + withdrawMoney );
			
			System.out.println("提領後帳戶金額:" + user.getAccount().getBalance());
		}
		else {
//			System.out.printf("%s 提領金額:%d, 超出帳戶餘額:%d\n"
//					,Thread.currentThread().getName()
//					,money,account.getBalance());
		}
	}
	
	public void Deposit(User user,int depositMoney) {
		if(depositMoney < user.getMoney()) {
			System.out.printf("%s 目前手頭金額:%d ,存款後帳戶餘額:%d\n"
					,user.getUserName()
					,user.getMoney()
					,user.getAccount().getBalance());
			
			user.setMoney(user.getMoney() - depositMoney);
			user.getAccount().setBalance( user.getAccount().getBalance() + depositMoney );
			System.out.printf("%s 目前手頭金額:%d ,存款後帳戶餘額:%d\n"
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
