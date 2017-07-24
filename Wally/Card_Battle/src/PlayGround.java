import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class PlayGround {
		
		static Scanner input = new Scanner(System.in);
		public static void main(String[] args) {
			
		SettingInformation.setUserOption();
		
	 	String inputUserModeOption = SettingInformation.getUserOption();
	 	String firstPlayerCard = " " ;
	 	String rivalCard = " " ;
	 	boolean isPlayer = inputUserModeOption.equals("玩家") ;
	 	boolean hasGeneral = false ;
	 	boolean hasKnignt = false ;
	 	boolean hasInfantry = false ;
	 	boolean hasSoldier = false ;
	 	int general = 0 ;
	 	int knignt = 0 ;
	 	int infantry = 0 ;
	 	int soldier = 0 ;
	 	int inputUserCardsOption = 0 ;
	 	int firstPlayerWinRecord = 0 ; 
	 	int rivalWinRecord = 0 ;
	 	
		Players firstPlayer = new Players();
		Players secondPlayer = new Players();
		Computer AI = new Computer();
		
		System.out.print("\n第一位玩家名稱: ");
		firstPlayer.playerNamed();
		
		if	(isPlayer){
			
			System.out.print("\n第二位玩家名稱: ");
			secondPlayer.playerNamed();
			
			while(isPlayerNameSame(firstPlayer,secondPlayer))
			secondPlayer.playerNamed();
		}				
			System.out.println("\n遊戲開始!");	
			
		for ( int i = 1 ; i < 8 ; i ++ ){
			
			System.out.println("\n第"+i+"回合 : ");
			System.out.println("\n第一位玩家的卡牌 :");
			for ( int j = 3 * ( i - 1 ) ; j < ( i * 3 ) ; j ++ ){
				System.out.println("第"+( ( ( j + 3 ) % 3 ) + 1 )+"張: "+firstPlayer.getPlayerCards(j));
			}
				System.out.print("\n第一位玩家想打出的卡牌 : ");
				inputUserCardsOption = (input.nextInt() - 1 ) + ( i - 1 ) * 3 ;
				firstPlayerCard = firstPlayer.getPlayerCards(inputUserCardsOption) ;
				System.out.println("第一位玩家打出了: "+firstPlayerCard);	
				
			if	(isPlayer){
				System.out.println("\n第二位玩家的卡牌 :");
				for ( int j = 3 * ( i - 1 ); j < ( i * 3 ) ; j ++ ){
					System.out.println("第"+( ( ( j + 3 ) % 3 ) + 1 )+"張: "+secondPlayer.getPlayerCards(j));	
				}
				System.out.print("\n第二位玩家想打出的卡牌 : ");
				inputUserCardsOption = (input.nextInt() - 1 ) + ( i - 1 ) * 3 ;
				rivalCard = secondPlayer.getPlayerCards(inputUserCardsOption) ;
				System.out.println("第二位玩家打出了: "+rivalCard+"\n");
			} // 玩家判別式
			else{
				System.out.println("\n電腦的卡牌 :");
				
				hasGeneral = false ;
			 	hasKnignt = false ;
			 	hasInfantry = false ;
			 	hasSoldier = false ;
			 	
				for ( int j = 3 * ( i - 1 ); j < ( i * 3 ) ; j ++ ){
					System.out.println("第"+( ( ( j + 3 ) % 3 ) + 1 )+"張: "+AI.getComputerCards(j));
					
					hasSoldier = ( ( AI.getComputerCards(j) ).equals("小兵") ) ;
					if	( ( ( AI.getComputerCards(j) ).equals("將軍") ) ){
						hasGeneral = true ;
						general = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("騎士") ) ){
						hasKnignt = true ;
						knignt = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("步兵") ) ){
						hasInfantry = true ;
						infantry = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("小兵") ) ){
						hasSoldier = true ;
						soldier = j ;
					}
				}
					System.out.print("\n電腦打出了 : ");
					if	( hasKnignt ){
						rivalCard =  AI.getComputerCards(knignt) ;
					}	
					else if ( hasInfantry ){
						rivalCard = AI.getComputerCards(infantry) ;
					}
					else if ( hasGeneral ){
						rivalCard =  AI.getComputerCards(general) ;
					}
					else
						rivalCard =  AI.getComputerCards(soldier) ;
					
					System.out.println(rivalCard+"\n");						
			} // 電腦判別式
				if	(!firstPlayerCard.equals(rivalCard)){
					if	( compareBiggerCard(firstPlayerCard, rivalCard) ){
						System.out.println("第一位玩家獲勝!");
						firstPlayerWinRecord = firstPlayer.playerWin() ;
					}
					
					else{
							if	( isPlayer ){
								System.out.println("第二位玩家獲勝!");
								rivalWinRecord = secondPlayer.playerWin() ;
							}	
							else{
								System.out.println("電腦獲勝");
								rivalWinRecord = AI.computerWin() ;
							}	
					}
				}
				else{
					System.out.println("雙方平手!");
				}
		} // 回合迴圈
					System.out.println("");
					
					if	( firstPlayerWinRecord == rivalWinRecord ){
						System.out.println("雙方平手!");	
					}
					else if ( firstPlayerWinRecord > rivalWinRecord ){
						System.out.println("第一位玩家贏了!");
					}
					else{
				
						if	( isPlayer ){
							System.out.println("第二位玩家贏了!");	
						}
						else
							System.out.println("電腦贏了!");
					}
					
	}	// Main
		private static boolean isPlayerNameSame( Object firstPlayer , Object secondPlayer ){
			
			if	((firstPlayer.toString()).equals(secondPlayer.toString())){
					System.out.println("該用戶名已存在  , 請重新輸入: ");
					System.out.print("第二位玩家名稱: ");
					return true ;
			}
			for ( int i = 0 ; i < (secondPlayer.toString()).length(); i ++ ){
				if	(((secondPlayer.toString().charAt(i))==' ')){
					System.out.println("玩家名稱中無法輸入空白字元 , 請重新輸入:");
					System.out.print("第二位玩家名稱: ");
					return true ;
				}	
			}
					return false ;
		} // 方法
		private static boolean compareBiggerCard( String firstPlayerCard , String rivalCard ) {
				
				switch	( firstPlayerCard ){
					
						case "將軍" :
							
							switch	( rivalCard ){
												
							case "騎士" :					
							case "步兵" :
							return true ;	
							
							}
							
						break ;
					
						case "騎士" :
							
							switch	( rivalCard ){
												
							case "步兵" :					
							case "小兵" :
							return true ;	
							
							}
							
						break ;
				
						case "步兵" :
							
							switch	( rivalCard ){

							case "小兵" :
							return true ;	
							
							}
							
						break ;
				
						case "小兵" :
							
							switch	( rivalCard ){	
							
							case "將軍" :
							return true ;	
							
							}
							
						break ;
				}
						return false ;
		}	// 方法
	
} // 類別
