package Visitor;

import Builder.FileBuilder;
import Composite.Building;
import Composite.CompositeMenuList;
import Composite.MenuCategory;
import Composite.MenuItem;
import Composite.Vendor;

public class MonotonousVisitor extends FileOutputVisitor {

	public MonotonousVisitor(FileBuilder builder) {
		super(builder);
	}

	@Override
	public void outputNode(CompositeMenuList node) {
	}

	@Override
	public void outputNode(Building node) {
		builder.addContent("�ؿv�W�١G " + node);
	}

	@Override
	public void outputNode(MenuItem node) {
		builder.addContent("-> " + node);
	}

	@Override
	public void outputNode(Vendor node) {
		builder.addContent("�u��Ω��a�W�١G" + node);
	}

	@Override
	public void outputNode(MenuCategory node) {
		builder.addContent("�����G" + node);		
	}

}
