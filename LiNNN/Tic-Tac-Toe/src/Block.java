
public class Block {

	private Group group;
	private static int NUMBER = 1;
	private int number;

	public Block() {
		super();
		group = Group.NUMBER;
		number = NUMBER++;
		if (NUMBER > 9)
			NUMBER = 1;
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

	@Override
	public String toString() {
		if (group == Group.NUMBER)
			return number + ",";
		else
			return group.getGraph() + ",";
	}

}
