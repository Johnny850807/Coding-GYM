package Bank;

public class Bank {	
	private int account_balance=5000;
	
	private boolean status=false;
	
	
	//存
	public void deposit(int money)
	{
		synchronized (this) 
		{
			account_balance+=money;
			
		}
	}
	
	//取
	public int draw(int money)
	{
		synchronized (this) 
		{
			if(account_balance<money)
			{
				System.out.println(" ,但是Bank餘額不足 剩餘"+account_balance);
				return account_balance;
			}
			else
			{
				account_balance-=money;
				System.out.println("Bank餘額剩餘"+account_balance);
			}
			
			return money;
		}
	}
	
	
	public boolean isGoBankrupt(){
		
		if(account_balance<=0){
			status=true;
		}
		
		return status;
	}
		

}
