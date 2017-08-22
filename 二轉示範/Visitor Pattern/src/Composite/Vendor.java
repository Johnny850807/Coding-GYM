package Composite;
import java.util.List;

import Visitor.Visitor;

public class Vendor extends MealsGettable {

	public Vendor(String selfName) {
		super( "Åu³c" , selfName);
	}
	
	@Override
	protected void printSubItems() {
		for ( MealsGettable m : menuList )
		{
			System.out.print("	");
			m.printSelfAndItems();
		}
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.outputNode(this);
	}
}