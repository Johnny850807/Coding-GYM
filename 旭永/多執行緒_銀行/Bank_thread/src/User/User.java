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
	
	//存
	public void deposit(int money)
	{
		if(init_money>money)
		{
			System.out.println(this.getClass().getSimpleName()+"存"+money+"元");
			b.deposit(money);
			init_money-=money;
		}
		else{
			System.out.println(money+"元存款失敗,"+this.getClass().getSimpleName()+"的餘額不足");
		}
	
	}
	
	//取
	public int draw(int money)
	{
		
		System.out.println(this.getClass().getSimpleName()+"領了"+money+"元    ");
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
