import java.time.Month;

public class Account {
	
	private String name;
	private int money;
	private int no;
	public static int withdrawLog;
	public static int depositLog;
	
	public Account(String name) {
		this.name = name;
		this.money = 10000;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	synchronized public int Withdraw(int money) {
		if(money > this.money) {
//			System.out.println("���B�����A������:" + money + " �Ѿl:" + this.money);
		}
		else {
			this.money -= money;
//			System.out.println("������B:" + money + "�Ѿl���B:" + this.money);
			this.withdrawLog += money;
			
			return this.money;
		}
		return 0;
	}
	
	synchronized public void Deposit(int money) {
		this.money += money;
		this.depositLog += money;
	}
	
	public String GetName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public int GetNo() {
		return no;
	}

	public void SetNo(int no) {
		this.no = no;
	}

}
