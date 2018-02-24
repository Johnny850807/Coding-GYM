import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuInformation {
	
	private String typeName;
	private List<MenuInformation> items;
	
	public Menu(String typeName) {
		this.typeName = typeName;
		items = new ArrayList<>();
	}

	public void add(MenuInformation item) {
		items.add(item);
	}
	
	@Override
	public void display() {
		System.out.println("¤ÀÃþ¡G" + typeName);
		for (MenuInformation item : items)
			item.display();
	}

}
