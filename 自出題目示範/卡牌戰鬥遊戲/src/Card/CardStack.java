package Card;

import java.util.Random;
import java.util.Stack;

public class CardStack extends Stack<Card>{
	
	public void shuffle(){
		Random random = new Random();
		for ( int i = 0 ; i < size() ; i ++ )
			swap(i,random.nextInt(size()));
	}
	
	private void swap(int index1 , int index2){
		Object card = elementData[index1];
		elementData[index1] = elementData[index2];
		elementData[index2] = card;
	}
	
	public static class Builder{
		private CardStack cardStack = new CardStack();
		private WhichCard whichCard;
		public Builder cardType(WhichCard whichCard){
			this.whichCard = whichCard;
			return this;
		}
		
		public Builder cardAmount(int amount){
			if ( whichCard == null )
				throw new NullPointerException("應該先設置卡片類型");
			for ( int i = 0 ; i < amount ; i ++ )
				cardStack.push(whichCard.which());
			return this;
		}
		
		public Builder shuffle(){
			cardStack.shuffle();
			return this;
		}
		
		public CardStack build(){
			return cardStack;
		}
		
		public interface WhichCard{
			Card which();
		}
	}
}
