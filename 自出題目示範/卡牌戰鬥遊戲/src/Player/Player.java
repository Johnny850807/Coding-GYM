package Player;

import Card.Card;
import Card.CardStack;

public abstract class Player {
	private int winRound;
	private String name;
	private CardStack cardStack;
	protected Card[] threeCards;
	
	public void setCardStack(CardStack cardStack) {
		this.cardStack = cardStack;
	}

	public Player(){}
	
	public Player(String name){
		this.name = name;
	}
	
	public void setup(){
		name = createName();
		System.out.println(name + " 命名成功。");
	}
	
	public void win(){
		winRound ++;
	}

	public int getWinRound() {
		return winRound;
	}
	
	public abstract String createName();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void fetchThreeCardsFromStack(){
		threeCards = new Card[3];
		for ( int i = 0 ; i < threeCards.length ; i ++ )
			threeCards[i] = cardStack.pop();
	}
	
	protected void printThreeCardsInfo(){
		StringBuilder strb = new StringBuilder();
		System.out.println(getName() + "擁有卡片： " );
		for ( int i = 0 ; i < threeCards.length ; i ++ )
			strb.append("(").append(i).append(") ").append(threeCards[i].getName()).append(" ");
		System.out.println(strb.toString());
	}
	
	public abstract Card chooseCardToFight();

}
