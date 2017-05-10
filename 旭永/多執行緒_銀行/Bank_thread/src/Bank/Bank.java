package Bank;

public class Bank {	
	private int account_balance=5000;
	
	private boolean status=false;
	
	
	//�s
	public void deposit(int money)
	{
		synchronized (this) 
		{
			account_balance+=money;
			
		}
	}
	
	//��
	public int draw(int money)
	{
		synchronized (this) 
		{
			if(account_balance<money)
			{
				System.out.println(" ,���OBank�l�B���� �Ѿl"+account_balance);
				return account_balance;
			}
			else
			{
				account_balance-=money;
				System.out.println("Bank�l�B�Ѿl"+account_balance);
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
