package Stock;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PriceRecord implements StockItem{
	private Stock ofStock;
	private LinkedList<Integer> records = new LinkedList<Integer>();
	
	public PriceRecord(Stock ofStock) {
		this.ofStock = ofStock;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		for (Integer price : records)
			strb.append(price).append(' ');
		return strb.toString();
	}

	@Override
	public void display() {
		System.out.println(this);
	}

	@Override
	public void newDay() {
		addNewRecord(ofStock.getPrice());
	}
	
	public void addNewRecord(int price){
		records.add(price);
		if (records.size() > 10)
			records.poll();
	}
	
	
}
