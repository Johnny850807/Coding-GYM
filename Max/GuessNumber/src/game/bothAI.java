package game;

import java.util.Random;

public class bothAI extends AI{
	private int guessNumber = 0;//���M�|��l���٬O���@�U�n�F
	
	public bothAI(){
		super(playerType.BOTHAI , "BOTHAI" );
	}
	//��@��H
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) );
		System.out.println("BOTHAI" + "  �q�F :" + guessNumber);
	return guessNumber;
	}
	
}
