package Composite;
import java.util.ArrayList;
import java.util.List;

import Visitor.Visitor;

public class MenuCategory extends MealsGettable {

	public MenuCategory(String selfName) {
		super( "¤ÀÃþ" , selfName);
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