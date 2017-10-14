package CardFight;

import java.util.ArrayList;
import java.util.Scanner;

import CardStack.Card;
import CardStack.CardStack;

public abstract class Player {

	Scanner input = new Scanner(System.in);
	protected String name;
	protected int victory;
	private CardStack cardStack = new CardStack();
	protected ArrayList<Card> cardStacks = new ArrayList<>();
	protected ArrayList<Card> handCards = new ArrayList<>();

	public Player() {
		super();
		named();
		cardStacks = cardStack.createStack();
		victory = 0;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		if (victory) {
			System.out.println(getName() + "Ĺ�o�o��");
			this.victory += 1;
		}
	}

	public abstract void named();

	public String getName() {
		return name;
	}

	public void draw() {
		for (int i = 0; i < 3; i++) {
			handCards.add(cardStacks.get(cardStacks.size() - 1));
			cardStacks.remove(cardStacks.size() - 1);
		}
	}
	
	public void isFinalWinner(Player player) {
		if (getVictory() > player.getVictory())
			System.out.println("�̲׵��G: " + getName() + " Win~~~");
		else if (getVictory() < player.getVictory())
			System.out.println("�̲׵��G: " + player.getName() + " Win~~~");
		else
			System.out.println("�̲׵��G: NoBody Win~~~");
	}

	public abstract Card fight();

	public abstract void handCards();

}
