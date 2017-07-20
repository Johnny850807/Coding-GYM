package �׷��K�X;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel {

	public static void main(String[] args) {
		AnswerOfGame answerOfGame = new AnswerOfGame();
		int answer = answerOfGame.getAnswerOfGame();
		System.out.println(answer);

		ArrayList<Player> player = new ArrayList<Player>();
		Scanner input = new Scanner(System.in);
		GameChecker gameChecker = new GameChecker();
		
		
		//Test
//		System.out.println("�Ш̧ǿ�J�u�ꪱ�a�B�_��AI�B����AI�B�_����AI�ƶq: ");
//		for (int i = 0; i < input.nextInt(); i++) {
//			player.add(new RealPlayer());
//		}
//		for (int i = 0; i < input.nextInt(); i++) {
//			player.add(new OddAI());
//		}
//		for (int i = 0; i < input.nextInt(); i++) {
//			player.add(new EvenAI());
//		}
//		for (int i = 0; i < input.nextInt(); i++) {
//			player.add(new SmartAI());
//		}
		player.add(new RealPlayer());
		player.add(new OddAI());
		player.add(new EvenAI());
		player.add(new SmartAI());
		
		for (Player list : player)
			System.out.println(list.guessNumber(1, 100));

	}

}
