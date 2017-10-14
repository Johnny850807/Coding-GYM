package CardFight;

import CardStack.Card;

public class AI extends Player {

	public AI() {
		super();
	}

	@Override
	public void named() {
		String[] AI_Name = { "武藤遊戲", "海馬瀨人", "喪家犬城之內", "孔雀舞", "羽蛾", "漠良", "yellow大謙", "Bang結石", "曾淦傑", "黃+尾", "墨水球",
				"鯉開灰", "吹豐雞", "張援鬆", "初戀 <3" };
		name = AI_Name[(int) (Math.random() * (AI_Name.length))];
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Card fight() {
		handCards();
		int choice = (int) (Math.random() * 3 + 1);
		System.out.println(getName() + " 派出了< " + handCards.get(choice - 1).getRank() + " >");
		return handCards.get(choice - 1);
	}

	@Override
	public void handCards() {
		draw();
	}

}
