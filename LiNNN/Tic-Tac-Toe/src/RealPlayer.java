
public class RealPlayer extends Player {

	@Override
	public void named() {
		System.out.println("�п�J�W��: ");
		name = input.nextLine();
	}

	@Override
	public int choice() {
		System.out.print("�п�J����ܮ�l��(1~9): ");
		int choice = input.nextInt();
		return choice;
	}

}
