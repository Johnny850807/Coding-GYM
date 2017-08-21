package 圈圈叉叉;

import java.util.Scanner;

public class TicTacToe {
	private Player[] players = new Player[2];
	private Board board;
	
	public TicTacToe() {
		board = new Board();
		createTwoPlayers();
	}
	
	public void createTwoPlayers() {
		Scanner input = new Scanner(System.in);
		char[] symbol = {'O', 'X'};
		for (int i = 0; i < 2; i++) {
			System.out.println("請輸入玩家" + (i+1) + " 類型：(1) 玩家 (2) 電腦");
			int type = input.nextInt();
			if (type == 1)
				players[i] = new HumanPlayer();
			else if (type == 2)
				players[i] = new AIPlayer();
			players[i].setSymbol(symbol[i]);
		}
	}
	
	public void gameStart() {
		boolean isWin = false;
		board.display();
		while (!isWin) {
			isWin = eachRound();
			System.out.println();
		}
		whoIsWinner();
		System.out.println("遊戲結束");
	}
	
	public boolean eachRound() {
		System.out.println("請輸入欲選擇格子數(1~9)");
		for (Player p : players) {
			System.out.print(p.getName() + "選擇了 ");
			int number = p.chooseBlockNumber(board);
			board.blockSelected(number, p.getSymbol());
			board.display();
			if (board.judgeWinOrNot())
				return true;
		}
		return false;
	}
	
	public void whoIsWinner() {
		if (board.getWinnerSymbol() == 'O')
			System.out.println(players[0].getName() + "贏了");
		else if (board.getWinnerSymbol() == 'X')
			System.out.println(players[1].getName() + "贏了");
		else 
			System.out.println("平手");
	}
}
