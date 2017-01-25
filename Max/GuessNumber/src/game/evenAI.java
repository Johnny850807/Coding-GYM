package game;

import java.util.Random;

public class evenAI extends AI{
	private int guessNumber = 0; //雖然會初始但還是打一下好了
	
	public evenAI(){
		super(playerType.EVENAI , "EVENAI" );
	}
	//實作抽象
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) && (guessNumber % 2 == 1) );
		System.out.println("EVENAI" + "  猜了 :" + guessNumber);
	return guessNumber;
	}
	
}
