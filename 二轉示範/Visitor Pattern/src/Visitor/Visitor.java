package Visitor;

import Composite.Building;
import Composite.CompositeMenuList;
import Composite.MenuCategory;
import Composite.MenuItem;
import Composite.Vendor;

public interface Visitor {
	public void outputNode(CompositeMenuList node); 
	public void outputNode(Building node); 
	public void outputNode(MenuItem node); 
	public void outputNode(Vendor node); 
	public void outputNode(MenuCategory node); 
}
