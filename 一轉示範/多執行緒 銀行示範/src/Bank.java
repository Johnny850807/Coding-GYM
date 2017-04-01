
public class Bank {
	private int money = 10000;
	private int outlay = 0;
	private int income = 10000;
	private boolean stop = false;
	
	public  void deposit(int money){
		this.money += money;
		stop = false;
		income += money;
	}
	
	public  int draw(int money) {
		int result;
		if ( this.money < money )
			result = this.money;
		else
			result = money;
		this.money -= result;
		
		outlay += result;
		
		return result; 
	}
	
	public boolean isStop(){
		if (money <= 0)
			stop = true;
		return stop;
	}
	
	public void setStop(boolean stop){
		this.stop = stop;
	}

	public int getOutlay() {
		return outlay;
	}

	public void setOutlay(int outlay) {
		this.outlay = outlay;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	
	
}
