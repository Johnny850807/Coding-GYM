import java.util.*;

public class Human extends Player {
	private ArrayList<Card> hasCard ;
	private int sum;
	public Human(String name){
		super(PlayerTypeEnum.HUMAN , name);
		initial();
	}
	public void initial(){
		hasCard = new ArrayList<Card>();
	}
	public void getCard(Card card){
		System.out.print(card.getCardType() + Integer.toString(card.getCardPoint()));
		hasCard.add(card);
	}
	public void printHasCard(){
		for (Card c : hasCard){
			System.out.print(c.getCardType() + Integer.toString(c.getCardPoint()));
		}
	}
	public int getTotPoint(){
		sum = 0;
		for (Card c : hasCard){
			sum += c.getCardPoint();
		}
		return sum;
	}
	public boolean playGame(Card card){
		char input;
		getCard(card);
		boolean canInput = true;
		boolean callGame =false;
		System.out.println("請問 " + name + " 是否繼續 y/n");
		do{
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine().charAt(0);
			System.out.println(input);
			if(input == 'y'){
				callGame =  false;
				break;
			}
			else if(input == 'n'){
				callGame =  true;
				break;
			}
			else{
				System.out.println("請輸入 y 或  n好嗎");
			}
		}while(canInput);
		
		return callGame;
	}
	
}
