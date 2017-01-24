package game;

import java.util.Random;

public class bothAI extends AI{
	private int guessNumber = 0;//雖然會初始但還是打一下好了
	
	public bothAI(){
		super(playerType.BOTHAI , "BOTHAI" );
	}
	//實作抽象
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) );
		System.out.println("BOTHAI" + "  猜了 :" + guessNumber);
	return guessNumber;
	}
	
}
