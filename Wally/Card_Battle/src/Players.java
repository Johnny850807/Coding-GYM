import java.util.Scanner;

public class Players {
	static Scanner input = new Scanner(System.in);
	
	public Players(){
	}
	
	private Cards playerCards = new Cards();
	private String playerName = " " ;
	private int playerWinRecord = 0 ;
	
	public void playerNamed(){
		playerName = input.nextLine();
	}
	
	public String getPlayerCards(int input){ 
		return playerCards.getCards(input) ;
	}
	
	public int playerWin() {
		playerWinRecord++ ;
		return playerWinRecord ;
	}
	
	public String toString(){
		return playerName ;
	} 
}
