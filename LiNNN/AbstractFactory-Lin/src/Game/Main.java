package Game;

public class Main {
	
	public static void main (String[] args) {
		GameCenter gameCenter = new GameCenter();
		gameCenter.createRole();
		gameCenter.createEnemy();
		gameCenter.gameStart();
		
	}

}
