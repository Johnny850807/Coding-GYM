package CardFight;

import CardStack.Card;

public class RealPlayer extends Player {

	public RealPlayer() {
		super();
	}

	@Override
	public void named() {
		System.out.print("請輸入名稱: ");
		name = input.nextLine();
	}

	@Override
	public Card fight() {
		handCards();
		int choice;
		do {
			System.out.println("請選擇欲出牌號: ");
			choice = input.nextInt();
		} while (choice > 3 || choice < 1);
		System.out.println(getName() + " 派出了< " + handCards.get(choice - 1).getRank() + " >");

		return handCards.get(choice - 1);
	}

	@Override
	public void handCards() {
		draw();
		for (int i = 0; i < 3; i++) {
			System.out.print((i + 1) + ". " + handCards.get(i).getRank() + " ");
		}
		System.out.println();

	}

}
