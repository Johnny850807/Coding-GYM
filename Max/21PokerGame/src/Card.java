public class Card {
	private int point;
	private CardTypeEnum cardtype;
	
	public void setCardPoint(int p){
		point = p;
	}
	public int getCardPoint(){
		return point;
	}
	public void setCardType(CardTypeEnum t){
		cardtype = t;
	}
	public CardTypeEnum getCardType(){
		return cardtype;
	}
	
}
