package game;
import java.util.*;
public class gameControl {
	
	private ArrayList<AI> players = new ArrayList<AI>();
	private guessNumber Game = guessNumber.getInstance();;
	private int PlayerCount , OddAICount , EvenAICount , BothAICount ;
	private String PlayerName;
	
	public void setGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�п�J�|�Ӽƶq(�H�ť�����})�G");
        PlayerCount = scanner.nextInt();
        OddAICount = scanner.nextInt();
        EvenAICount = scanner.nextInt();
        BothAICount = scanner.nextInt();
        System.out.print(" ���a�ƶq�G" + PlayerCount );
        System.out.print(" �_AI�ƶq�G" + OddAICount );
        System.out.print(" ��AI�ƶq�G" + EvenAICount );
        System.out.println(" ���qAI�ƶq�G" + BothAICount );	
        
        //���a�W�ٿ�J
        for (int i = 0; i < PlayerCount; i++){
        	System.out.print("��J�U�Ӫ��a�W�١G");
        	PlayerName = scanner.next();
        	players.add(new Player(PlayerName));
        	System.out.println();
        	
        }
        //�UAI��JArrayList��
        setOdd();
        setEven();
        setBoth();
        
        //�{���ì~���ӥ�
        for ( int time = 0 ; time < 10 ; time ++ ) 
			for ( int i = 0 ; i < players.size() ; i ++ )  
			{
				int index = new Random().nextInt(players.size());
				AI temp = players.get(i);  
				players.set(i,players.get(index));
				players.set(index,temp);
			}
        //��ܶ���
        for (AI player: players){
        	System.out.println("��  " + players.indexOf(player) + " �쪱�a�� : " +player.getName());
        }
        
        //�}�l�C��
        startPlaying();
	}
	
	private void setOdd(){
		for (int i = 0; i < OddAICount; i++){
			players.add(new oddAI());
        }
	}
	
	private void setEven(){
		for (int i = 0; i < EvenAICount; i++){
			players.add(new evenAI());
        }
	}
	
	private void setBoth(){
		for (int i = 0; i < BothAICount; i++){
			players.add(new bothAI());
        }
	}
	
	private void startPlaying(){
		
		boolean bgo = false;
		do{
			for (AI player: players){
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        		System.out.println("���a�W��  :" + player.getName() + " ");	
        		bgo = Game.checkGuess(player);
				if ( bgo == true)
					break;
				System.out.println("�٨S�q���!! ");	
				}
		}while ( !bgo);
		
		finnsh();
	
	}
	private void finnsh(){
		System.out.println("����");
	}
	
}
