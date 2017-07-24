package 沧伐盞絏;

import java.util.*;

public class Game {
	private int realAmount, oddAmount, evenAmount, smartAmount;
	private ArrayList<Player> players = new ArrayList<Player>();
	AnswerOfGame answerOfGame = new AnswerOfGame();
	final int answer = answerOfGame.getAnswerOfGame();

	public void setGame() {

		System.out.println(answer);
		Scanner input = new Scanner(System.in);
		
		System.out.println("叫ㄌ块痷龟產计AI案计AI案计AI计秖: ");
		realAmount = input.nextInt();
		oddAmount = input.nextInt();
		evenAmount = input.nextInt();
		smartAmount = input.nextInt();

		for (int i = 0; i < realAmount; i++) 
			players.add(new RealPlayer());

		for (int i = 0; i < oddAmount; i++) 
			players.add(new OddAI());
	
		for (int i = 0; i < evenAmount; i++) 
			players.add(new EvenAI());

		for (int i = 0; i < smartAmount; i++) 
			players.add(new SmartAI());


		for (int time = 0; time < 10 ; time++)
			for (int i = 0; i < players.size(); i++) {
				int index = new Random().nextInt(players.size());
				Player temp = players.get(i);
				players.set(i, players.get(index));
				players.set(index, temp);
			}

		for (Player player : players) {  
			System.out.println("材  " + ((players.indexOf(player)) + 1) + " 產 : " + player.getPlayerName());
		}
		startGame();
	}

	public void startGame() {
		GameChecker gameChecker = new GameChecker();
		while (!gameChecker.getBingo()) {
			for (Player player : players) {
				gameChecker.checkAnswer(answer, 
						player.guessNumber(gameChecker.getSmall(), gameChecker.getBig()));
				if ( gameChecker.getBingo() )
					break;
			}
		}
	}

}
