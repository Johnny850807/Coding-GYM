import java.util.Scanner;

public class GuessNumber {
	
	static Scanner input = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
	int randomNumber = ( Player.randomInput ).nextInt( 101 ) ;	
	
	System.out.println(randomNumber);
	
	int upperNumber = 100 ;
	int lowerNumber = 0 ;
	
	System.out.print("�п�J���a�ƶq : ");
	int humanPlayerAmount = input.nextInt();
	System.out.print("�п�J�q�_��AI�ƶq : ");
	int guessOddNumberAIAmount = input.nextInt();
	System.out.print("�п�J�q����AI�ƶq : ");
	int guessEvenNumberAIAmount = input.nextInt();
	System.out.print("�п�J�q�_����AI�ƶq : ");
	int guessOddEvenNumberAIAmount = input.nextInt();
	System.out.println("\n�Ҧ����a�ƶq��J����!\n");
	
	int totalPlayersAmount = humanPlayerAmount + guessOddNumberAIAmount + guessEvenNumberAIAmount + guessOddEvenNumberAIAmount ;
	
	int playersAmountSum = 0 ;
	
	Player guessNumberPlayers [] = new Player [ totalPlayersAmount ] ;
	
	playersAmountSum = humanPlayerAmount ; 
	for	( int i = 0 ; i < playersAmountSum ; i ++ ){
		guessNumberPlayers [ i ] = new Player();
		( guessNumberPlayers [ i ] ).setPlayerName();
	}	 	
	playersAmountSum += guessOddNumberAIAmount ; 
	for	( int i = ( playersAmountSum - guessOddNumberAIAmount ) ; i < playersAmountSum ; i ++ ){
		guessNumberPlayers [ i ] = new GuessOddNumberAI();
	}	 	
	playersAmountSum += guessEvenNumberAIAmount ; 
	for	( int i = ( playersAmountSum - guessEvenNumberAIAmount ) ; i < playersAmountSum ; i ++ ){
		guessNumberPlayers [ i ] = new GuessEvenNumberAI();
	}		
	playersAmountSum += guessOddEvenNumberAIAmount ; 
	for	( int i = ( playersAmountSum - guessOddEvenNumberAIAmount ) ; i < totalPlayersAmount ; i ++ ){
		guessNumberPlayers [ i ] = new GuessOddEvenNumberAI();
	}		

	int randomInput = 0 ;

	Player temp ;

	for	( int i = 0 ; i < totalPlayersAmount ; i ++ ){
		for	( int j = 0 ; j < totalPlayersAmount ; j ++ ){
			randomInput = ( Player.randomInput ).nextInt( totalPlayersAmount ) ;
			temp = guessNumberPlayers [ j ] ;
			guessNumberPlayers [ j ] = guessNumberPlayers [ randomInput ] ;
			guessNumberPlayers [ randomInput ] = temp ;
		}
	}
	
	int playerGuessNumber = 0 ;
	
	System.out.println("\n�C���}�l\n") ;
	
	boolean hasNotBingo = true ;
	
	do{
			for	( int i = 0 ; i < totalPlayersAmount ; i ++ ){
				System.out.print( "�q���Ʀr�d�� : " + lowerNumber+" ~ "+ upperNumber + "\n\n�п�J�q���Ʀr :" ) ;
				( guessNumberPlayers [ i ] ).setPlayerNumber();
				playerGuessNumber = ( guessNumberPlayers [ i ] ).getPlayerNumber() ;
				System.out.println( guessNumberPlayers [ i ] + " �q�����Ʀr : " + playerGuessNumber + "\n" );
			
				if	( randomNumber == playerGuessNumber ){
					System.out.println( "��!!\n�C������\n" );
					hasNotBingo = false ;
					break ;
				}
				if	( randomNumber < playerGuessNumber && upperNumber > playerGuessNumber ){
					upperNumber = playerGuessNumber ;
				}
				if	( randomNumber > playerGuessNumber && lowerNumber < playerGuessNumber ){
					lowerNumber = playerGuessNumber ;
				}	
			} // �q���j��
	}while(hasNotBingo) ;	// �L���j��	
	
	} // Main

} // ���O
