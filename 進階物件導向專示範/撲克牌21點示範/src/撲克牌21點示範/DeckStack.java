package ¼³§JµP21ÂI¥Ü½d;

import java.util.Random;
import java.util.Stack;

public class DeckStack extends Stack<Card> implements PokeCard {
	
	public void createAndShuffle(){
		create52Cards();
		shuffleTenTimes();
	}
	
	public void create52Cards(){
		SuitEnum[] suits = SuitEnum.values();
		RankEnum[] ranks = RankEnum.values();
		for ( int i = 0 ; i < 4 ; i ++ )
			for ( int j = 0 ; j < 13 ; j ++ )
				push(new Card(ranks[j] , suits[i]));
	}
	
	public void shuffleTenTimes(){
		for ( int i = 0 ; i < 10 ; i ++ )
			randomlySwapShuffle();
	}
	
	public void randomlySwapShuffle(){
		Random rand = new Random();
		for ( int i = 0 ; i < size() ; i ++ )
			swapTwoCards( i , rand.nextInt(size()) );
	}
	
	private void swapTwoCards(int i , int j){
		Object temp = elementData[i];
		elementData[i] = elementData[j];
		elementData[j] = temp;
	}
	
	@Override
	public void print() {
		for (int i = 0 ; i < size() ; i ++ )
		{
			if ( i % 13 == 0 )
				System.out.println();
			System.out.print(elementData[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] argv){
		DeckStack d = new DeckStack();
		d.createAndShuffle();
		d.print();
	}
}
