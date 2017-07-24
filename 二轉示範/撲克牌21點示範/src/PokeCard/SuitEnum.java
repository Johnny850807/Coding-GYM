package PokeCard;

//每種牌花色的列舉，管理其印出字樣
public enum SuitEnum {
	PLUM("梅花") , DIAMOND("菱形") , HEART("愛心") , SPADE("黑桃");
	String name;
	private SuitEnum(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}

}
