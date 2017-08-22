package Composite;
import java.util.ArrayList;
import java.util.List;

import Visitor.Visitor;

public class Building extends MealsGettable {

	public Building(String selfName) {
		super( "«Ø¿v" , selfName);
	}
	
	@Override
	protected void printSubItems() {
		for ( MealsGettable m : menuList )
			m.printSelfAndItems();
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.outputNode(this);
	}

	

}
