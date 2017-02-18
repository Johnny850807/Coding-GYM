
public enum PlayerTypeEnum {
	HUMAN("人類玩家") , AI("人工智慧");
	String playerType;
	
	private PlayerTypeEnum(String playertype){
		this.playerType = playertype;
	}
	
	@Override
	public String toString() {
		return playerType;
	}
}
