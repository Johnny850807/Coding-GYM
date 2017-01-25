package game;
import java.util.*;
public class Player extends AI{
	private int guessNumber ;
	private String PlayerName;
	private boolean checkRange = false;
	
	public Player(String name){
		super(playerType.PLAYER , name);
	}
	//實作抽象
	public int guessNumber(int l ,int h){
		while(!checkRange){
		 Scanner scanner = new Scanner(System.in);
	     System.out.println("請輸入數字 ：");
	     guessNumber = scanner.nextInt();
	     
	     if(guessNumber > l && guessNumber < h){
	    	 checkRange = true;
	    	 System.out.println("您輸入數字為 : " + guessNumber);
	     }
	     else
	    	 System.out.println("您輸入數字須在範圍內 : " + l + " ~ " + h );
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
