package �׷��K�X�hAI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Delayed;

import Util.Input;

public class Main {

	public static void main(String[] args) {
		GuessGame game = new GuessGame();
		List<Player> players = createPlayers();
		
		System.out.println("���Ǭ� : ");
		for ( Player p : players )
			System.out.print(p.getName());
		System.out.println();
		
		game.createAnswer();
		int turn = 0;
		
		do  
		{
			Player player = players.get(turn);
			System.out.println(game.getMin() + "~" + game.getMax());
			int guess = player.guess(game.getMin(), game.getMax());
			System.out.println(player.getName() + " �q�F" + guess);
			boolean win = game.guess(guess);
			if (win)
				System.out.println(player.getName() + "�q��F !");
			turn = turn + 1 >= players.size() ? 0 : turn + 1;
			delay();
		}while(!game.isOver());

	}
	
	private static List<Player> createPlayers(){
		List<Player> players = new ArrayList<Player>();
		int human = Input.nextInt("��J�X��{�ꪱ�a�G");
		int odd = Input.nextInt("��J�X��_�ƫ��q�����a: ");
		int even = Input.nextInt("��J�X�참�ƫ��q�����a: ");
		for ( int i = 0 ; i < human; i ++ )
			players.add(new HumanPlayer());
		for ( int i = 0 ; i < odd; i ++ )
			players.add(new OddAI());
		for ( int i = 0 ; i < even; i ++ )
			players.add(new EvenAI());
		
		Collections.shuffle(players);
		
		return players;
	}
	
	private static void delay(){
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
