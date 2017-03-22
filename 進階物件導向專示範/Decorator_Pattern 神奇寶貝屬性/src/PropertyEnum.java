
public enum PropertyEnum {
	
	WATER(true),
	FIRE(true),
	THUNDER(true),
	ICE(true),
	GRASS(true),
	GROUND(false),
	FLY(false);
	
	
	boolean special;
	
	private PropertyEnum(boolean isSp){
		//設定是否為特殊攻擊
		this.special = isSp;
	}
	
	boolean isSpecial(){
		return this.special;
	}
}
