package BlackJack;

public class RealPlayer extends Player {

	@Override
	public String named() {
		System.out.println("請輸入玩家名稱: ");
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
