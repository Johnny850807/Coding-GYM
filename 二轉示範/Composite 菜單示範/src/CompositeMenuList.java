import java.util.ArrayList;



class CompositeMenuList extends MealsGettable{
	

	public CompositeMenuList(String selfName) {
		super("�j��", selfName);
	}

	@Override
	protected void printSubItems() {
		for ( MealsGettable mealsGettable : menuList)
			mealsGettable.printSelfAndItems();
	}
		
	
}
	