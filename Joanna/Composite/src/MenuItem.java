
public class MenuItem implements MenuInformation {
	
	private String itemName;
	
	public MenuItem(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public void add(MenuInformation information) {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void display() {
		System.out.println("¦WºÙ¡G" + itemName);
	}

}
