package game;
import java.util.*;
public class oddAI extends AI{
	private int guessNumber = 0;//���M�|��l���٬O���@�U�n�F
	public oddAI(){
		super(playerType.ODDAI , "ODDAI" );
	}
	//��@��H
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) && (guessNumber % 2 == 0 ) );
		System.out.println( "ODDAI"  + "  �q�F :" + guessNumber);
	return guessNumber;
	}
	
}
