
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
		//�]�w�O�_���S�����
		this.special = isSp;
	}
	
	boolean isSpecial(){
		return this.special;
	}
}
