import java.util.Scanner;

public abstract class Player {
	Scanner input = new Scanner(System.in);
	
	protected String name;
	private boolean graph;
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Player() {
		super();
		nameSelf();
	}
	
	public void setGraph(int choice) {
		if (choice == 0) {
			graph = true;
		}
		else if (choice == 1)
			graph = false;
	}
	
	public boolean getGraph() {
		return graph;
	}
	
	public abstract void nameSelf();
	
	public String getName() {
		return name;
	}

	public abstract int choice();
	
}
