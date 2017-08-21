package ���e�e;

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
			System.out.println("�п�J���a" + (i+1) + " �����G(1) ���a (2) �q��");
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
		System.out.println("�C������");
	}
	
	public boolean eachRound() {
		System.out.println("�п�J����ܮ�l��(1~9)");
		for (Player p : players) {
			System.out.print(p.getName() + "��ܤF ");
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
			System.out.println(players[0].getName() + "Ĺ�F");
		else if (board.getWinnerSymbol() == 'X')
			System.out.println(players[1].getName() + "Ĺ�F");
		else 
			System.out.println("����");
	}
}
