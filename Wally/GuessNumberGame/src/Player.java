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
				System.out.print("�Э��s��J0~100���Ʀr : ");
			}
		}while( playerNumber > 101 );
	} // �]�K�X��k

	public int getPlayerNumber(){
		return playerNumber ;
	} // Ū�K�X��k
	
	protected void setPlayerName() {
		System.out.print("�п�J���a�W : ");
		playerName = (GuessNumber.input).next();
	} // ���W��k
	
	public String toString() {
		return "���a"+playerName ;
	} // Ū�W��k
	
	
} // ���O
