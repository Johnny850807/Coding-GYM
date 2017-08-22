package Composite;
import java.util.ArrayList;



public class CompositeMenuList extends MealsGettable{
	
	public CompositeMenuList(String selfName) {
		super("¤j¾Ç", selfName);
	}

	@Override
	protected void printSubItems() {
		for ( MealsGettable mealsGettable : menuList)
			mealsGettable.printSelfAndItems();
	}
		
	
}
	