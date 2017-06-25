package User;

import java.util.Random;

import Bank.Bank;

public abstract class User implements Runnable{
	
	private int init_money=3000;
	private static Bank b;
	
	public User(Bank b)
	{
		this.b=b;
	}
	
	//�s
	public void deposit(int money)
	{
		if(init_money>money)
		{
			System.out.println(this.getClass().getSimpleName()+"�s"+money+"��");
			b.deposit(money);
			init_money-=money;
		}
		else{
			System.out.println(money+"���s�ڥ���,"+this.getClass().getSimpleName()+"���l�B����");
		}
	
	}
	
	//��
	public int draw(int money)
	{
		
		System.out.println(this.getClass().getSimpleName()+"��F"+money+"��    ");
		int getmoney = b.draw(money);
		init_money+=money;
		
		return getmoney;
	}

	
	
	@Override
	public void run()
	{
		
		while(!b.isGoBankrupt())
		{
			int choose=(int)(Math.random()*2+1);
					
			if(choose ==1)
			{
				int draw=(int)(Math.random()*3000+900);
				draw(draw);
					
			}
			else
			{
				int deposit=(int)(Math.random()*3000+900);
				
				deposit(deposit);
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
