package Composite;
import java.util.List;

import Visitor.Visitor;

public class MenuItem extends MealsGettable {

	public MenuItem(String selfName) {
		super( "À\ÂI" , selfName);
	}
	
	@Override
	protected void printSubItems() {}  /**There is no more sub item**/

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.outputNode(this);
	}
}
