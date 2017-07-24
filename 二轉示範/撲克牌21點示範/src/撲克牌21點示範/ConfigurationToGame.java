package 撲克牌21點示範;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Player.AI_Player;
import Player.HumanPlayer;
import Player.Player;
import PokeCard.DeckStack;
import Strategy.RandomChoice;

public class ConfigurationToGame {
	//遊戲設置過程封裝在這個類別，遊戲只需要跟這個類別拿取所需資源即可。
	private static Scanner scanner = new Scanner(System.in);
	private int createPlayerAmount = 1;
	private int createAIAmount = 3;
	private ArrayList<Player> playerList = new ArrayList<Player>();

	//得到打亂順序的玩家串列以及印出順序
	public ArrayList<Player> getShuffledPlayerListAndPrintOrder(){
		addHumanPlayer();  //先增加人類玩家
		addAiPlayer();  //再增加AI
		Collections.shuffle(playerList);  //洗牌
		printPlayerListOrder();  //印出順序
		return playerList;  
	}
	
	private void addHumanPlayer(){
		for ( int i = 0 ; i < createPlayerAmount ; i ++ )
			playerList.add(new HumanPlayer());
	}
	
	private void addAiPlayer(){
		for ( int i = 0 ; i < createAIAmount ; i ++ )
			playerList.add( new AI_Player( new RandomChoice())); //隨機決策的笨AI
	}
	
	private void printPlayerListOrder(){
		System.out.println("順序 : ");
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
	
	//呼叫這個函數才會開始進行輸入設置相關常數
	public void doAllSettingInput(){
		 inputPlayerAmount();
		 inputAIAmount();
	}
	
	private void inputPlayerAmount(){
		do
		{
			System.out.println("設置玩家數量(0~10): ");
			createPlayerAmount = scanner.nextInt();
		} while ( createPlayerAmount < 0 || createPlayerAmount > 10 );
		
	}
	
	private void inputAIAmount(){
		int baseBound = 2 - createPlayerAmount < 0 ? 0 : 2 - createPlayerAmount  ;
		int upperBound = 10 - createPlayerAmount;
		do
		{
			System.out.printf("設置電腦數量(%d~%d): ", baseBound , upperBound);
			createAIAmount = scanner.nextInt();
		} while ( createAIAmount < baseBound || createAIAmount > upperBound );
		
	}
	
	
}
