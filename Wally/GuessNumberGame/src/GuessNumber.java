import java.util.Scanner;

public class GuessNumber {
	
	static Scanner input = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
	int randomNumber = ( Player.randomInput ).nextInt( 101 ) ;	
	
	System.out.println(randomNumber);
	
	int upperNumber = 100 ;
	int lowerNumber = 0 ;
	
	System.out.print("請輸入玩家數量 : ");
	int humanPlayerAmount = input.nextInt();
	System.out.print("請輸入猜奇數AI數量 : ");
	int guessOddNumberAIAmount = input.nextInt();
	System.out.print("請輸入猜偶數AI數量 : ");
	int guessEvenNumberAIAmount = input.nextInt();
	System.out.print("請輸入猜奇偶數AI數量 : ");
	int guessOddEvenNumberAIAmount = input.nextInt();
	System.out.println("\n所有玩家數量輸入完畢!\n");
	
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
	
	System.out.println("\n遊戲開始\n") ;
	
	boolean hasNotBingo = true ;
	
	do{
			for	( int i = 0 ; i < totalPlayersAmount ; i ++ ){
				System.out.print( "猜測數字範圍 : " + lowerNumber+" ~ "+ upperNumber + "\n\n請輸入猜測數字 :" ) ;
				( guessNumberPlayers [ i ] ).setPlayerNumber();
				playerGuessNumber = ( guessNumberPlayers [ i ] ).getPlayerNumber() ;
				System.out.println( guessNumberPlayers [ i ] + " 猜測的數字 : " + playerGuessNumber + "\n" );
			
				if	( randomNumber == playerGuessNumber ){
					System.out.println( "中!!\n遊戲結束\n" );
					hasNotBingo = false ;
					break ;
				}
				if	( randomNumber < playerGuessNumber && upperNumber > playerGuessNumber ){
					upperNumber = playerGuessNumber ;
				}
				if	( randomNumber > playerGuessNumber && lowerNumber < playerGuessNumber ){
					lowerNumber = playerGuessNumber ;
				}	
			} // 猜測迴圈
	}while(hasNotBingo) ;	// 過關迴圈	
	
	} // Main

} // 類別
