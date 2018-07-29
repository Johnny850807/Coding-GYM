package SynchronizedTest;

public class Account {
	
	public String userName;
	public Bank bank;
	static private int balance;
	private int acctNo;
	public static int acctNoPool = 0;
	
	//constructor
	public Account(Bank bank,String name) {
		this.bank = bank;
		this.userName = name;
		this.balance = 10000; //��l���B
		this.acctNo = acctNoPool++; //�b��s��
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public int getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
