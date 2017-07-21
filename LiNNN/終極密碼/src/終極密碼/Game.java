package �׷��K�X;

import java.util.*;

public class Game {
	private int realAmount, oddAmount, evenAmount, smartAmount;
	private ArrayList<Player> player = new ArrayList<Player>();
	AnswerOfGame answerOfGame = new AnswerOfGame();
	final int answer = answerOfGame.getAnswerOfGame();

	public void setGame() {
		
		System.out.println(answer);

		Scanner input = new Scanner(System.in);
		

		// Test
		System.out.println("�Ш̧ǿ�J�u�ꪱ�a�B�_��AI�B����AI�B�_����AI�ƶq: ");
		realAmount = input.nextInt();
		oddAmount = input.nextInt();
		evenAmount = input.nextInt();
		smartAmount = input.nextInt();

		for (int i = 0; i < realAmount; i++) {
			player.add(new RealPlayer());
		}
		for (int i = 0; i < oddAmount; i++) {
			player.add(new OddAI());
		}
		for (int i = 0; i < evenAmount; i++) {
			player.add(new EvenAI());
		}
		for (int i = 0; i < smartAmount; i++) {
			player.add(new SmartAI());
		}

		for (int time = 0; time < 10; time++)
			for (int i = 0; i < player.size(); i++) {
				int index = new Random().nextInt(player.size());
				Player temp = player.get(i);
				player.set(i, player.get(index));
				player.set(index, temp);
			}

		for (Player players : player) {
			System.out.println("��  " + ((player.indexOf(players)) + 1) + " �쪱�a�� : " + players.getPlayerName());
		}
		startGame();
	}

	public void startGame() {
		GameChecker gameChecker = new GameChecker();
		while (!gameChecker.getBingo()) {
			for (Player list : player) {
				gameChecker.checkAnswer(answer, list.guessNumber(gameChecker.getSmall(), gameChecker.getBig()));
				if ( gameChecker.getBingo() == true )
					break;
			}
		}
	}

}
