package ���J�P21�I�ܽd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConfigurationToGame {
	//�C���]�m�ʸ˦b�o�����O �]�O²�檺�u�t���O
	private static Scanner scanner = new Scanner(System.in);
	private int createPlayerAmount = 1;
	private int createAIAmount = 3;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	public ConfigurationToGame(){}

	public ArrayList<Player> getShuffledPlayerListAndPrintOrder(){
		addHumanPlayer();
		addAiPlayer();
		shufflePlayerList();
		printPlayerListOrder();
		return playerList;
	}
	
	private void addHumanPlayer(){
		for ( int i = 0 ; i < createPlayerAmount ; i ++ )
			playerList.add(new HumanPlayer());
	}
	
	private void addAiPlayer(){
		for ( int i = 0 ; i < createAIAmount ; i ++ )
			playerList.add( new AI_Player( new RandomChoice())); //�H���M������AI
	}
	
	private void shufflePlayerList(){
		Random random = new Random();
		for ( int i = 0 ; i < playerList.size() ; i ++ )
			swapTwoPlayerByIndex( i , random.nextInt(playerList.size()) );
	}
	
	private void swapTwoPlayerByIndex(int i , int j){
		Player temp = playerList.get(i);
		playerList.set(i ,playerList.get(j) );
		playerList.set(j, temp);
	}
	
	private void printPlayerListOrder(){
		System.out.println("���� : ");
		for ( Player p : playerList )
			System.out.print(p+" -> ");
		System.out.println();
	}
	
	public DeckStack getDeck(){
		DeckStack deck = new DeckStack();
		deck.createAndShuffle();
		return deck;
	}
	
	public DeckStack getDiscards(){
		return new DeckStack();
	}
	
	public void doAllSettingInput(){
		 inputPlayerAmount();
		 inputAIAmount();
	}
	
	private void inputPlayerAmount(){
		do
		{
			System.out.println("�]�m���a�ƶq(0~10): ");
			createPlayerAmount = scanner.nextInt();
		} while ( createPlayerAmount < 0 || createPlayerAmount > 10 );
		
	}
	
	private void inputAIAmount(){
		int baseBound = 2 - createPlayerAmount < 0 ? 0 : 2 - createPlayerAmount  ;
		int upperBound = 10 - createPlayerAmount;
		do
		{
			System.out.printf("�]�m�q���ƶq(%d~%d): ", baseBound , upperBound);
			createAIAmount = scanner.nextInt();
		} while ( createAIAmount < baseBound || createAIAmount > upperBound );
		
	}
	
	
}
