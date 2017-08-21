package Model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String account;
	private String password;
	private int money;
	private List<Product> products = new ArrayList<>();
	
	public User(String name, String account, String password, int money) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return String.format("©m¦W¡G %s, ª÷¿ú¡G %d", name, money);
	}
	
}
