
public class RealPlayer extends Player {

	@Override
	public String named() {
		System.out.println("�п�J�W��: ");
		name = input.nextLine();
		return name;
	}

	@Override
	public int Choice() {
		System.out.print("�п�J����ܮ�l��(1~9): ");
		int choice = input.nextInt();
		return choice;
	}

}
