package client.Player;

public abstract class Player {
	private String name;
	
	public Player() {
		name = nameSelf();
	}

	protected abstract String nameSelf();
	
	public abstract int guess(int min, int max);
	
	public String getName() {
		return name;
	}
}
