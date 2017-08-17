
public class Block {

	private Group group;

	public Block() {
		super();
		group = Group.NUMBER;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public boolean haveBeenChosen() {
		return this.group != Group.NUMBER;
	}

	public String displayBlock(int i) {
		if (group == Group.NUMBER)
			return Integer.toString(i) + ",";
		else 
			return group.getGraph() + ",";
		
	}
	
}
