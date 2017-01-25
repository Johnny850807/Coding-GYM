package game;

public enum playerType {
	PLAYER("ª±®a"),ODDAI("©_AI"),EVENAI("°¸AI"),BOTHAI("ÂùAI");
	String type;
	private playerType(String type){
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}
	
}
