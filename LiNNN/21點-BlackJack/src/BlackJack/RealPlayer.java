package BlackJack;

public class RealPlayer extends Player {

	@Override
	public String named() {
		System.out.println("�п�J���a�W��: ");
		name = input.nextLine();
		return name;
	}

	@Override
	public boolean choice(int point) {
		String choice = input.next();
		if (choice.equals("N") || choice.equals("n")) {
			return false;
		} else
			return true;
	}

}
