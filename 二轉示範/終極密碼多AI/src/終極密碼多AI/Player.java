package ²×·¥±K½X¦hAI;

public abstract class Player {
	private String name;
	
	public Player(){
		name = nameSelf();
	}
	
	protected abstract String nameSelf();
	protected abstract String getPlayerType();
	protected abstract int guess(int min, int max);

	public String getName() {
		return "(" + getPlayerType() + ":" + name + ")";
	}
}
