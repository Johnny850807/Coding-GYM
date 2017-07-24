package 終極密碼多AI;

public enum PlayerType {
	PLAYER("玩家"),AIODD("奇數電腦"),AIEVEN("偶數電腦");
	String type;
	
	private PlayerType(String type){
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
}
