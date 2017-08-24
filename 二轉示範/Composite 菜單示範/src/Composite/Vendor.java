package Composite;
import java.util.List;

public class Vendor extends MealsGettable {

	public Vendor(String selfName) {
		super( "�u�c" , selfName);
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