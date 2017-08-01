package Player;

import Card.*;

public abstract class Player {
	protected String name;
	protected int score;
	protected CardDeck cardDeck;
	
	public Player() {
		super();
		name = nameSelf();
		score = 0;
		cardDeck = new CardDeck();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public CardDeck getCardDeck() {
		return cardDeck;
	}

	public void computeScore(int score) {
		this.score += score;
	}
	
	protected abstract String nameSelf();
	public abstract int selectCard();
}
