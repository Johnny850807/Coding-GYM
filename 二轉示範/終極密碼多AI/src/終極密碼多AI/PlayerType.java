package �׷��K�X�hAI;

public enum PlayerType {
	PLAYER("���a"),AIODD("�_�ƹq��"),AIEVEN("���ƹq��");
	String type;
	
	private PlayerType(String type){
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
}
