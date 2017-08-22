package Visitor;

import Builder.FileBuilder;
import Composite.Building;
import Composite.CompositeMenuList;
import Composite.MenuCategory;
import Composite.MenuItem;
import Composite.Vendor;

public class AbundantVisitor extends FileOutputVisitor{

	public AbundantVisitor(FileBuilder builder) {
		super(builder);
	}
	
	@Override
	public void outputNode(CompositeMenuList node) {}

	@Override
	public void outputNode(Building node) {
		builder.addContent("==建築==");
		builder.addContent("名稱：");
		builder.addContent(node.toString());
	}

	@Override
	public void outputNode(MenuItem node) {
		builder.addContent("-> " + node);
	}

	@Override
	public void outputNode(Vendor node) {
		builder.addContent("==攤位及店家==");
		builder.addContent(".............................................");
		builder.addContent("名稱：" + node);
	}

	@Override
	public void outputNode(MenuCategory node) {
		builder.addContent("分類：" + node);
	}

}

