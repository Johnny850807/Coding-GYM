package game;
import java.util.*;
public class Player extends AI{
	private int guessNumber ;
	private String PlayerName;
	private boolean checkRange = false;
	
	public Player(String name){
		super(playerType.PLAYER , name);
	}
	//��@��H
	public int guessNumber(int l ,int h){
		while(!checkRange){
		 Scanner scanner = new Scanner(System.in);
	     System.out.println("�п�J�Ʀr �G");
	     guessNumber = scanner.nextInt();
	     
	     if(guessNumber > l && guessNumber < h){
	    	 checkRange = true;
	    	 System.out.println("�z��J�Ʀr�� : " + guessNumber);
	     }
	     else
	    	 System.out.println("�z��J�Ʀr���b�d�� : " + l + " ~ " + h );
		}
	     return guessNumber;      
	}
	
	public void setPlayerName(String s){
		PlayerName = s;
	}
	public String getPlayerName(){
		return PlayerName;
	}

}
