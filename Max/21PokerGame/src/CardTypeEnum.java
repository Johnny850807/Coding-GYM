public enum CardTypeEnum {
	SPADES("�®�"),HEARTS("����"),DIAMONDS("���"),CLUBS("����");
	String cardType;
	
	private CardTypeEnum(String cardtype){
		this.cardType = cardtype;
	}
	
	@Override
	public String toString() {
		return cardType;
	}
}

