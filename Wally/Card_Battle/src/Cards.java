import java.util.Random;

public class Cards {
	static Random takeCard = new Random();
	public Cards() {
	setCardContents(cards);
	cardsShuffle(cards);
	}
	private String cards[] = new String [21] ;
	private void setCardContents(String str []) {
	//	3張將軍、5張騎士、7張步兵和6張小兵
	for	(int i = 0 ; i < str.length ; i++ )	
		{
			if( i < 3 )
			str[i]="將軍" ;
			else if ( i > 2 && i < 8 )
			str[i]="騎士" ;
			else if ( i > 7 && i < 15 )
			str[i]="步兵" ;
			else
			str[i]="小兵" ;	
		}
	}
	private static void cardsShuffle(String str []) {
		int randomNumber = 0 ;
		String temp = " " ;
		for ( int i = 0 ; i < str.length ; i ++ )
		for	(int j = 0 ; j < str.length ; j++ )	
		{
			randomNumber = takeCard.nextInt(21);
			temp = str[j] ; 
			str [j] = str[randomNumber] ;
			str[randomNumber] = temp ;
		}		
	}
	public String getCards( int input ){
		return cards[input] ;	
	}

}
