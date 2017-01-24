package game;
import java.util.*;
public class oddAI extends AI{
	private int guessNumber = 0;//雖然會初始但還是打一下好了
	public oddAI(){
		super(playerType.ODDAI , "ODDAI" );
	}
	//實作抽象
	public int guessNumber(int l , int h){
		do{
			guessNumber = new Random().nextInt(h-l)+l;
		}while( (guessNumber < l || guessNumber > h) && (guessNumber % 2 == 0 ) );
		System.out.println( "ODDAI"  + "  猜了 :" + guessNumber);
	return guessNumber;
	}
	
}
