package PokeCard;

public class Card implements PokeCard{
	private RankEnum rank;
	private SuitEnum suit;
	
	public Card(RankEnum rank, SuitEnum suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public void print() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return suit.toString() + rank.toString();
	}
	
	public int getPoint(){
		return rank.getPoint();
	}

	public RankEnum getRank() {
		return rank;
	}

	public void setRank(RankEnum rank) {
		this.rank = rank;
	}

	public SuitEnum getSuit() {
		return suit;
	}

	public void setSuit(SuitEnum suit) {
		this.suit = suit;
	}


	public static void main(String[] argv){
		Card c = new Card(RankEnum._10,SuitEnum.PLUM);
		System.out.println(c);
		c.print();
	}
}
