
public enum PlayerTypeEnum {
	HUMAN("�H�����a") , AI("�H�u���z");
	String playerType;
	
	private PlayerTypeEnum(String playertype){
		this.playerType = playertype;
	}
	
	@Override
	public String toString() {
		return playerType;
	}
}
