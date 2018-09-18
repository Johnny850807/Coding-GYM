
public class AI extends Player {
	String[] AI_NAME = { "Johnny", "Lin", "Joanna" };
	
	@Override
	public void nameSelf() {
		name = AI_NAME[(int) (Math.random() * (AI_NAME.length))];
	}

	@Override
	public int choice() {
		int choice = (int) (Math.random() * 9 + 1);
		return choice;
	}

}
