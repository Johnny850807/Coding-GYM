import java.util.ArrayList;

public class MenuCategory extends MealsGettable {

	public MenuCategory(String selfName) {
		super( "����" , selfName);
	}

	@Override
	protected void printSubItems() {
		for ( MealsGettable m : menuList )
		{
			System.out.print("	");
			m.printSelfAndItems();
		}
	}

	


}