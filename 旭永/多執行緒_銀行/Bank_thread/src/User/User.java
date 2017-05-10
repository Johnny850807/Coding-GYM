package User;

import java.util.Random;

import Bank.Bank;

public abstract class User {
	int init_money=3000;
	
	Bank b;
	public User(Bank b)
	{
		this.b=b;
	}

	
	//存
	void deposit(int money)
	{

		if(money>init_money)
		{
//			Thread.currentThread().getName()
			System.out.println(this.getClass().getSimpleName()+"要領"+money+"元"
						+"但餘額不足 , Bank餘額剩"+b.account_balance );
			return;
		}
		
		b.account_balance+=money;
		init_money-=money;
		System.out.println(this.getClass().getSimpleName()+"存了"+money+"元    "+
				this.getClass().getSimpleName()+"剩"+init_money+"元"+
				"  Bank餘額剩:" + b.account_balance );
		
		
	}
	
	//取
	int draw(int money){
		
		
		if(  money >b.account_balance ){
			System.out.print(this.getClass().getSimpleName()+"領了"+money);
			System.out.println("     Bank餘額不足  餘額剩"+b.account_balance);
			
			return b.account_balance  ;
		}
		

		b.account_balance-=money;
		init_money+=money;
		System.out.println(this.getClass().getSimpleName()+"領了"+money+
				"元    "+this.getClass().getSimpleName()+"剩"+init_money+"元"+
				"   Bank餘額剩:"+b.account_balance);
		
		return b.account_balance;
		 
	}

}
