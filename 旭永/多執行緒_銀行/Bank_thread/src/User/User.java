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

	
	//�s
	void deposit(int money)
	{

		if(money>init_money)
		{
//			Thread.currentThread().getName()
			System.out.println(this.getClass().getSimpleName()+"�n��"+money+"��"
						+"���l�B���� , Bank�l�B��"+b.account_balance );
			return;
		}
		
		b.account_balance+=money;
		init_money-=money;
		System.out.println(this.getClass().getSimpleName()+"�s�F"+money+"��    "+
				this.getClass().getSimpleName()+"��"+init_money+"��"+
				"  Bank�l�B��:" + b.account_balance );
		
		
	}
	
	//��
	int draw(int money){
		
		
		if(  money >b.account_balance ){
			System.out.print(this.getClass().getSimpleName()+"��F"+money);
			System.out.println("     Bank�l�B����  �l�B��"+b.account_balance);
			
			return b.account_balance  ;
		}
		

		b.account_balance-=money;
		init_money+=money;
		System.out.println(this.getClass().getSimpleName()+"��F"+money+
				"��    "+this.getClass().getSimpleName()+"��"+init_money+"��"+
				"   Bank�l�B��:"+b.account_balance);
		
		return b.account_balance;
		 
	}

}
