import java.util.Random;

public class Cards {
	static Random takeCard = new Random();
	public Cards() {
	setCardContents(cards);
	cardsShuffle(cards);
	}
	private String cards[] = new String [21] ;
	private void setCardContents(String str []) {
	//	3�i�N�x�B5�i�M�h�B7�i�B�L�M6�i�p�L
	for	(int i = 0 ; i < str.length ; i++ )	
		{
			if( i < 3 )
			str[i]="�N�x" ;
			else if ( i > 2 && i < 8 )
			str[i]="�M�h" ;
			else if ( i > 7 && i < 15 )
			str[i]="�B�L" ;
			else
			str[i]="�p�L" ;	
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
