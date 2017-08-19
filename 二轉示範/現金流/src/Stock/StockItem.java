package Stock;

import java.io.Serializable;

public interface StockItem extends Serializable{
	public void display();
	public void newDay();  //新的一天開始囉
}
