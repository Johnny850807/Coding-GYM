package game;

import java.util.Random;

public class evenAI extends AI{
	private int guessNumber = 0; //���M�|��l���٬O���@�U�n�F
	
	public evenAI(){
		super(playerType.EVENAI , "EVENAI" );
	}
	//��@��H
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) && (guessNumber % 2 == 1) );
		System.out.println("EVENAI" + "  �q�F :" + guessNumber);
	return guessNumber;
	}
	
}
