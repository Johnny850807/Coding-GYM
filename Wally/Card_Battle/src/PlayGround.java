import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class PlayGround {
		
		static Scanner input = new Scanner(System.in);
		public static void main(String[] args) {
			
		SettingInformation.setUserOption();
		
	 	String inputUserModeOption = SettingInformation.getUserOption();
	 	String firstPlayerCard = " " ;
	 	String rivalCard = " " ;
	 	boolean isPlayer = inputUserModeOption.equals("���a") ;
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
		
		System.out.print("\n�Ĥ@�쪱�a�W��: ");
		firstPlayer.playerNamed();
		
		if	(isPlayer){
			
			System.out.print("\n�ĤG�쪱�a�W��: ");
			secondPlayer.playerNamed();
			
			while(isPlayerNameSame(firstPlayer,secondPlayer))
			secondPlayer.playerNamed();
		}				
			System.out.println("\n�C���}�l!");	
			
		for ( int i = 1 ; i < 8 ; i ++ ){
			
			System.out.println("\n��"+i+"�^�X : ");
			System.out.println("\n�Ĥ@�쪱�a���d�P :");
			for ( int j = 3 * ( i - 1 ) ; j < ( i * 3 ) ; j ++ ){
				System.out.println("��"+( ( ( j + 3 ) % 3 ) + 1 )+"�i: "+firstPlayer.getPlayerCards(j));
			}
				System.out.print("\n�Ĥ@�쪱�a�Q���X���d�P : ");
				inputUserCardsOption = (input.nextInt() - 1 ) + ( i - 1 ) * 3 ;
				firstPlayerCard = firstPlayer.getPlayerCards(inputUserCardsOption) ;
				System.out.println("�Ĥ@�쪱�a���X�F: "+firstPlayerCard);	
				
			if	(isPlayer){
				System.out.println("\n�ĤG�쪱�a���d�P :");
				for ( int j = 3 * ( i - 1 ); j < ( i * 3 ) ; j ++ ){
					System.out.println("��"+( ( ( j + 3 ) % 3 ) + 1 )+"�i: "+secondPlayer.getPlayerCards(j));	
				}
				System.out.print("\n�ĤG�쪱�a�Q���X���d�P : ");
				inputUserCardsOption = (input.nextInt() - 1 ) + ( i - 1 ) * 3 ;
				rivalCard = secondPlayer.getPlayerCards(inputUserCardsOption) ;
				System.out.println("�ĤG�쪱�a���X�F: "+rivalCard+"\n");
			} // ���a�P�O��
			else{
				System.out.println("\n�q�����d�P :");
				
				hasGeneral = false ;
			 	hasKnignt = false ;
			 	hasInfantry = false ;
			 	hasSoldier = false ;
			 	
				for ( int j = 3 * ( i - 1 ); j < ( i * 3 ) ; j ++ ){
					System.out.println("��"+( ( ( j + 3 ) % 3 ) + 1 )+"�i: "+AI.getComputerCards(j));
					
					hasSoldier = ( ( AI.getComputerCards(j) ).equals("�p�L") ) ;
					if	( ( ( AI.getComputerCards(j) ).equals("�N�x") ) ){
						hasGeneral = true ;
						general = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("�M�h") ) ){
						hasKnignt = true ;
						knignt = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("�B�L") ) ){
						hasInfantry = true ;
						infantry = j ;
					}
					if	( ( ( AI.getComputerCards(j) ).equals("�p�L") ) ){
						hasSoldier = true ;
						soldier = j ;
					}
				}
					System.out.print("\n�q�����X�F : ");
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
			} // �q���P�O��
				if	(!firstPlayerCard.equals(rivalCard)){
					if	( compareBiggerCard(firstPlayerCard, rivalCard) ){
						System.out.println("�Ĥ@�쪱�a���!");
						firstPlayerWinRecord = firstPlayer.playerWin() ;
					}
					
					else{
							if	( isPlayer ){
								System.out.println("�ĤG�쪱�a���!");
								rivalWinRecord = secondPlayer.playerWin() ;
							}	
							else{
								System.out.println("�q�����");
								rivalWinRecord = AI.computerWin() ;
							}	
					}
				}
				else{
					System.out.println("���襭��!");
				}
		} // �^�X�j��
					System.out.println("");
					
					if	( firstPlayerWinRecord == rivalWinRecord ){
						System.out.println("���襭��!");	
					}
					else if ( firstPlayerWinRecord > rivalWinRecord ){
						System.out.println("�Ĥ@�쪱�aĹ�F!");
					}
					else{
				
						if	( isPlayer ){
							System.out.println("�ĤG�쪱�aĹ�F!");	
						}
						else
							System.out.println("�q��Ĺ�F!");
					}
					
	}	// Main
		private static boolean isPlayerNameSame( Object firstPlayer , Object secondPlayer ){
			
			if	((firstPlayer.toString()).equals(secondPlayer.toString())){
					System.out.println("�ӥΤ�W�w�s�b  , �Э��s��J: ");
					System.out.print("�ĤG�쪱�a�W��: ");
					return true ;
			}
			for ( int i = 0 ; i < (secondPlayer.toString()).length(); i ++ ){
				if	(((secondPlayer.toString().charAt(i))==' ')){
					System.out.println("���a�W�٤��L�k��J�ťզr�� , �Э��s��J:");
					System.out.print("�ĤG�쪱�a�W��: ");
					return true ;
				}	
			}
					return false ;
		} // ��k
		private static boolean compareBiggerCard( String firstPlayerCard , String rivalCard ) {
				
				switch	( firstPlayerCard ){
					
						case "�N�x" :
							
							switch	( rivalCard ){
												
							case "�M�h" :					
							case "�B�L" :
							return true ;	
							
							}
							
						break ;
					
						case "�M�h" :
							
							switch	( rivalCard ){
												
							case "�B�L" :					
							case "�p�L" :
							return true ;	
							
							}
							
						break ;
				
						case "�B�L" :
							
							switch	( rivalCard ){

							case "�p�L" :
							return true ;	
							
							}
							
						break ;
				
						case "�p�L" :
							
							switch	( rivalCard ){	
							
							case "�N�x" :
							return true ;	
							
							}
							
						break ;
				}
						return false ;
		}	// ��k
	
} // ���O
