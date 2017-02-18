import java.util.Random;


public class CardPile {
	private Card[] card;
	private int startCard = 0;
	public CardPile(){
		card = new Card[52];
		setCard();
		randomCard();
	}
	
	public void setCard(){
		for(int i = 0 ; i < 52; i++)
			card[i] = new Card();
		
		for (int i = 0; i < 52; i++){
		      switch ( i % 4){
		        case 0:
		        	card[i].setCardType(CardTypeEnum.SPADES);
		        	card[i].setCardPoint(i % 13 + 1);
		        	break;
		        case 1:
		        	card[i].setCardType(CardTypeEnum.HEARTS);
		        	card[i].setCardPoint(i % 13 + 1);
		        	break;
		        case 2:
		        	card[i].setCardType(CardTypeEnum.DIAMONDS);
		        	card[i].setCardPoint(i % 13 + 1);
		        	break;
		        case 3:
		        	card[i].setCardType(CardTypeEnum.CLUBS);
		        	card[i].setCardPoint(i % 13 + 1);
		        	break;
		      }
		    }
		
	}
	
	public void randomCard(){
		int x ;
		CardTypeEnum typeTemp;
		int pointTemp;
		for (int time = 0 ; time < 1; time++)
			for (int i = 0 ; i < 52;i++){
				x = new Random().nextInt(52);
				typeTemp = card[i].getCardType();
				pointTemp = card[i].getCardPoint();

				card[i].setCardType(card[x].getCardType());
				card[i].setCardPoint(card[x].getCardPoint());
				
				card[x].setCardPoint(pointTemp);
				card[x].setCardType(typeTemp);
				
				
			}
	}
	public Card getCard(){
		return card[startCard++];
	}
	public boolean checkHasCard(){
		if(startCard < 52)
			return true;
		else
			return false;
	}
	public void printCard(){
		for (int i = 0 ; i < 52;i++){
			if( i % 13 == 0)
				System.out.println();
			System.out.print(card[i].getCardType() + " = " + card[i].getCardPoint() + "   ");
			
		}
	}
	
}
