package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String name;
	private int price;
	private Date date;
	
	public Product(String name, int price, Date date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}
	
	public Product(String name, int price, String date) throws ParseException {
		this(name, price);
		setDate(date);
	}
	
	public Product(String name, int price) {
		this(name, price, new Date());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDate(String dateString) throws ParseException {
		this.date = format.parse(dateString);
	}
	
	public String dateToString() {
		return format.format(date);
	}
	
}
