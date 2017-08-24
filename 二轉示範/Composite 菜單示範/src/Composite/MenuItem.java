package Composite;
import java.util.List;

public class MenuItem extends MealsGettable {

	public MenuItem(String selfName) {
		super( "À\ÂI" , selfName);
	}
	
	@Override
	protected void printSubItems() {}  /**There is no more sub item**/

}
