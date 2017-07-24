import java.util.Random;

public class Computer {
	public Computer() {	
	}
	private Random named = new Random();
	private int computerWinRecord = 0 ;
	private int computerID = named.nextInt(899)+100;
	private String computerName = String.valueOf(computerID);
	private Cards computerCards = new Cards();
	
	public String getComputerCards(int input){ 
		return computerCards.getCards(input) ;
	}
	
	public String cardPick( String card ) {
	
		if	( card.equals("騎士") )
				return card ;
		else if	( card.equals("步兵") )
				return card ;
		else if	( card.equals("將軍") )
				return card ;
		else
				return card ;
	}
	
	public int computerWin() {
		computerWinRecord++ ;
		return computerWinRecord ;
	}
	
	public String toString(){
		return computerName ;
	} 

}
