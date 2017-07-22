package 沧伐盞絏;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("块摸產计秖");
		int humanAmount = input.nextInt();
		System.out.println("块计AI计秖");
		int oddAIAmount = input.nextInt();
		System.out.println("块案计AI计秖");
		int evenAIAmount = input.nextInt();
		System.out.println("块计案计常瞦AI计秖");
		int AIAmount = input.nextInt();
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i=0; i<humanAmount; i++) {
			System.out.println("块材" + (i+1) + "摸產嘿");
			Human h = new Human();
			String humanName = input.next();
			h.setName(humanName);
			players.add(h);
		}
		for (int i=0; i<oddAIAmount; i++) {
			OddAI o = new OddAI();
			o.setName("计AI");
			players.add(o);
		}
		for (int i=0; i<evenAIAmount; i++) {
			EvenAI e = new EvenAI();
			e.setName("案计AI");
			players.add(e);
		}
		for (int i=0; i<AIAmount; i++) {
			AI a = new AI();
			a.setName("计案计AI");
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
		System.out.println("笴栏挡");
	}

	
}
