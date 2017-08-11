package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import PokeCard.Card;
import Strategy.ChoiceStrategy;
import ���J�P21�I�ܽd.Game21Point;

public abstract class Player{
	protected ChoiceStrategy makeChoiceStrategy;
	
	protected List<Card> handCards = Collections.checkedList(new ArrayList(), Card.class);
	protected String name = "";
	protected int score; //�`���Z
	public static int playerAmount = 0;
	
	
	public Player(ChoiceStrategy makeChoiceStrategy){
		playerAmount++;
		this.makeChoiceStrategy = makeChoiceStrategy;
		name = createName();
	}
	
	public boolean makeChoiceProcess(){
		System.out.printf("�а�  %s �n½�}�U�@�i�P��(y/n)? %n",name);
		return makeChoiceToReceiveNextCardOrNot();
	}
	
	// �ⰵ��ܪ��t��k�e��������h����
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
