package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import PokeCard.Card;
import Strategy.ChoiceStrategy;
import 撲克牌21點示範.Game21Point;

public abstract class Player{
	protected ChoiceStrategy makeChoiceStrategy;
	
	protected List<Card> handCards = Collections.checkedList(new ArrayList(), Card.class);
	protected String name = "";
	protected int score; //總成績
	public static int playerAmount = 0;
	
	
	public Player(ChoiceStrategy makeChoiceStrategy){
		playerAmount++;
		this.makeChoiceStrategy = makeChoiceStrategy;
		name = createName();
	}
	
	public boolean makeChoiceProcess(){
		System.out.printf("請問  %s 要翻開下一張牌嗎(y/n)? %n",name);
		return makeChoiceToReceiveNextCardOrNot();
	}
	
	// 把做抉擇的演算法委派給物件去執行
	private boolean makeChoiceToReceiveNextCardOrNot(){
		return makeChoiceStrategy.makeChoiceToReceiveNextCardOrNot(this);
	}
	
	protected abstract String createName();
	
	public int getHandCardsPoint(){
		int point = 0;
		for ( Card card : handCards )
			point += card.getPoint();
		return point;
	}
	
	public void clearHandCards(){
		this.handCards.clear();
	}
	
	public boolean isHandCardsOutOfBount(){
		return getHandCardsPoint() > Game21Point.MAX_POINT;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addHandCard(Card card){
		this.handCards.add(card);
	}

	public int getScore() {
		return score;
	}
	
	public void win(){
		this.score ++;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

	
	
}
