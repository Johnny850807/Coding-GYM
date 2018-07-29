import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	public List<Account> accounts = new ArrayList();
	public static Account publicAccount = new Account("Public Account");
	
	public void AddAccount(User user) {
		accounts.add(user.account);
		
		int index = accounts.size()-1;
		accounts.get(index).SetNo(index);
	}
	
	public void DelAccount(User user) {
		accounts.remove(user.account.GetNo());
	}
	
	//copy paste
	public boolean IsBroke(){
		return publicAccount.getMoney() <= 0;
	}
}
