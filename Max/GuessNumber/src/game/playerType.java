package game;

public enum playerType {
	PLAYER("���a"),ODDAI("�_AI"),EVENAI("��AI"),BOTHAI("��AI");
	String type;
	private playerType(String type){
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}
	
}
