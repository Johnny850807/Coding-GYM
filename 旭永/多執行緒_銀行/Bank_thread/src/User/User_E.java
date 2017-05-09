package User;

import Bank.Bank;

public class User_E extends User implements Runnable{
	


	public User_E(Bank b) {
		super(b);
	}

	@Override
	public void run()
	{
		while( b.account_balance > 0 )
		{
			
		
				synchronized(b)
				{
				
					
						int choose=(int)(Math.random()*2+1);
						
						
						if(choose ==1)
						{
							int draw=(int)(Math.random()*3000+900);
							
							draw(draw);
						
							
							if(b.account_balance==0){
								Thread.yield();
							}
							b.draw_money+=draw;
						}
						
						else
						{
							int deposit=(int)(Math.random()*3000+900);
							deposit(deposit);				
							b.deposit_money+=deposit;
						}
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.getMessage();
						}
					
			}
			
			
			
			
		}

		
	}
	
}
