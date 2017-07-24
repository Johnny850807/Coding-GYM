package 終極密碼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("輸入人類玩家數量");
		int humanAmount = input.nextInt();
		System.out.println("輸入奇數AI數量");
		int oddAIAmount = input.nextInt();
		System.out.println("輸入偶數AI數量");
		int evenAIAmount = input.nextInt();
		System.out.println("輸入奇數偶數都猜的AI數量");
		int AIAmount = input.nextInt();
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i=0; i<humanAmount; i++) {
			System.out.println("輸入第" + (i+1) + "位人類玩家名稱");
			Human h = new Human();
			players.add(h);
		}
		
		for (int i=0; i<oddAIAmount; i++) {
			OddAI o = new OddAI();
			players.add(o);
		}

		for (int i=0; i<evenAIAmount; i++) {
			EvenAI e = new EvenAI();
			players.add(e);
		} 
		
		for (int i=0; i<AIAmount; i++) {
			AI a = new AI();
			players.add(a);
		}
		
		for (int i=0; i<players.size(); i++) {
			Random ran = new Random();
			int temp = (int) ran.nextInt(players.size());
			Collections.swap(players, i, temp);
		}
		
		/*
		for (int i=0; i<players.size(); i++) {
			System.out.println(players.get(i).getClass());
			System.out.println(players.get(i).getName());
		}
		*/
		
		GuessNumberGame game = new GuessNumberGame();	
		game.startGame(players);
		System.out.println("遊戲結束");
	}

	
}
