import java.util.Random;

public class Player {

	public Player() {	
	}
	
	public static Random randomInput = new Random() ;
	protected int playerNumber = 0 ;
	private int playerID = 0 ;
	protected String playerName = " " ;
	
	public void setPlayerNumber(){
		do{
			playerNumber = (GuessNumber.input).nextInt() ;
			if ( playerNumber > 101 ){
				System.out.print("請重新輸入0~100的數字 : ");
			}
		}while( playerNumber > 101 );
	} // 設密碼方法

	public int getPlayerNumber(){
		return playerNumber ;
	} // 讀密碼方法
	
	protected void setPlayerName() {
		System.out.print("請輸入玩家名 : ");
		playerName = (GuessNumber.input).next();
	} // 取名方法
	
	public String toString() {
		return "玩家"+playerName ;
	} // 讀名方法
	
	
} // 類別
