import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User implements Runnable{
	private static Random random = new Random();
	private static final String[] NAMES = {"Binzhong","ZongYee","Max","ShengSheng","Fongshu","Waterball","Fireball","ShengFong","WangNing","Fucker"};
	private String name;
	private static int nameIndex = 0;
	private int money = 3000;
	private Bank bank;
	
	public User(Bank bank){
		this.bank = bank;
	}
	
	@Override
	public void run() {
		if (name == null)
			Thread.currentThread().setName(NAMES[ ++nameIndex % NAMES.length]);
		
		while(!bank.isStop())
		{
			try {
				TimeUnit.SECONDS.sleep(random.nextInt(5));
				
				if (random.nextBoolean())
					deposit(random.nextInt(money)+1);
				else
					draw(random.nextInt(6900)+100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void deposit(int amount){
		System.out.printf("User %s is depositting , Amount : %d ...%n" , Thread.currentThread().getName() , amount);
		bank.deposit(amount);
		money -= amount;
	}
	
	private void draw(int amount){
		int result = bank.draw(amount);
		System.out.printf("User %s is drawing , Amount : %d ... , Get : %d %n" , Thread.currentThread().getName() , amount , result);
		money += result;
	}

}
