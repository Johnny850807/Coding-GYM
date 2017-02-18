public enum CardTypeEnum {
	SPADES("¶Â®ç"),HEARTS("¬õ¤ß"),DIAMONDS("¤è¶ô"),CLUBS("±öªá");
	String cardType;
	
	private CardTypeEnum(String cardtype){
		this.cardType = cardtype;
	}
	
	@Override
	public String toString() {
		return cardType;
	}
}

