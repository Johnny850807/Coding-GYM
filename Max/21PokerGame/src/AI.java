import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AI extends Player{
	private ArrayList<Card> hasCard;
	private int sum;
	
	public AI(String name){
		super(PlayerTypeEnum.AI ,name);
		initial();
	}
	public void initial(){
		hasCard = new ArrayList<Card>();
	}
	public void getCard(Card card){
		hasCard.add(card);
	}
	public void printHasCard(){
		for (Card c : hasCard){
			System.out.print(c.getCardType() + Integer.toString(c.getCardPoint()));
		}
	}
	public boolean playGame(Card card){
		int x;
		getCard(card);
		boolean callGame =false;
		System.out.println("請問 " + name + " 是否繼續 y/n");
		x = new Random().nextInt(7);
		if(x == 1){
			System.out.println("y");
			callGame =  false;
		}
		else {
			System.out.println("n");
			callGame =  true;
		}		
		return callGame;
	}
	public int getTotPoint(){
		sum = 0;
		for (Card c : hasCard){
			sum += c.getCardPoint();
		}
		return sum;
	}
}
