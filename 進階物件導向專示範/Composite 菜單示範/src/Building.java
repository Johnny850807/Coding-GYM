
public class Building extends MealsGettable {

	public Building(String selfName) {
		super( "�ؿv" , selfName);
	}
	
	@Override
	protected void printSubItems() {
		for ( MealsGettable m : menuList )
			m.printSelfAndItems();
	}

}
