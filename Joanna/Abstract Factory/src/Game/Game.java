package Game;

import Player.Hero;
import Player.Monster;
import Player.Player;
import Weapon.Attackable;
import Weapon.Weapon;

public class Game {
	
	private Player[] players = new Player[2];
	private Player nowPlayer;
	
	public Game() {
		players[0] = new Hero();
		players[1] = new Monster();
	}
	
	public boolean isGameOver() {
		for (Player player : players) 
			if (player.getHealthPoint() < 0) 
				return true;
		return false;
	}
	
	public void init() {
		for (Player player : players) {
			int roleSelection = player.selectRole();
			player.setRole(roleSelection);
		}
		nowPlayer = players[0];
	}
	
	public void start() {
		while (!isGameOver()) {
			System.out.println(nowPlayer.getName() + "...");
			System.out.println("狀態: HP-->" + nowPlayer.getHealthPoint() + ", MP-->" + nowPlayer.getMagicPoint());
			Attackable weapon = nowPlayer.selectAction();
			System.out.println(nowPlayer.getName() + " 使用 " + weapon.getName() + " 進行攻擊!!!!!");
			
			nowPlayer.subtractMagicPoint(weapon.getLoseMp());
		
			getOpponent(nowPlayer).gotHurted(weapon);
			
			turnNextPlayer();	
		}
		System.out.println("GameOver");
	}
	
	private Player getOpponent(Player nowPlayer) {
		return (nowPlayer == players[1])? players[0] : players[1];
	}
	
	private void turnNextPlayer() {
		nowPlayer = (nowPlayer == players[1])? players[0] : players[1];
	}
	
	public static void main(String[] argv) {
		Game game = new Game();
		game.init();
		game.start();	
	}
}
