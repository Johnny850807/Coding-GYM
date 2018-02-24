import java.util.ArrayList;
import java.util.List;

public class Shop implements MenuInformation {

	private String shopName;
	private List<MenuInformation> items;
	
	public Shop(String shopName) {
		this.shopName = shopName;
		items = new ArrayList<>();
	}

	public void add(MenuInformation item) {
		items.add(item);
	}
	
	@Override
	public void display() {
		System.out.println("À\ÆU :" + shopName);
		for (MenuInformation menu : items)
			menu.display();
		
	}

}
