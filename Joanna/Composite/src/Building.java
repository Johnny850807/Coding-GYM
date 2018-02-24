import java.util.ArrayList;
import java.util.List;

public class Building implements MenuInformation {

	private String buildingName;
	private List<MenuInformation> items;
	
	public Building(String buildingName) {
		this.buildingName = buildingName;
		items = new ArrayList<>();
	}

	@Override
	public void add(MenuInformation information) {
		items.add(information);
	}

	@Override
	public void display() {
		System.out.println("«Ø¿vª« :" + buildingName);
		for (MenuInformation information : items)
			 information.display();
	}
	
}
