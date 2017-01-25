package game;
import java.util.*;
public class gameControl {
	
	private ArrayList<AI> players = new ArrayList<AI>();
	private guessNumber Game = guessNumber.getInstance();;
	private int PlayerCount , OddAICount , EvenAICount , BothAICount ;
	private String PlayerName;
	
	public void setGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入四個數量(以空白鍵分開)：");
        PlayerCount = scanner.nextInt();
        OddAICount = scanner.nextInt();
        EvenAICount = scanner.nextInt();
        BothAICount = scanner.nextInt();
        System.out.print(" 玩家數量：" + PlayerCount );
        System.out.print(" 奇AI數量：" + OddAICount );
        System.out.print(" 偶AI數量：" + EvenAICount );
        System.out.println(" 都猜AI數量：" + BothAICount );	
        
        //玩家名稱輸入
        for (int i = 0; i < PlayerCount; i++){
        	System.out.print("輸入各個玩家名稱：");
        	PlayerName = scanner.next();
        	players.add(new Player(PlayerName));
        	System.out.println();
        	
        }
        //各AI放入ArrayList中
        setOdd();
        setEven();
        setBoth();
        
        //現成亂洗拿來用
        for ( int time = 0 ; time < 10 ; time ++ ) 
			for ( int i = 0 ; i < players.size() ; i ++ )  
			{
				int index = new Random().nextInt(players.size());
				AI temp = players.get(i);  
				players.set(i,players.get(index));
				players.set(index,temp);
			}
        //顯示順序
        for (AI player: players){
        	System.out.println("第  " + players.indexOf(player) + " 位玩家為 : " +player.getName());
        }
        
        //開始遊戲
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
        		System.out.println("玩家名稱  :" + player.getName() + " ");	
        		bgo = Game.checkGuess(player);
				if ( bgo == true)
					break;
				System.out.println("還沒猜到喔!! ");	
				}
		}while ( !bgo);
		
		finnsh();
	
	}
	private void finnsh(){
		System.out.println("結束");
	}
	
}
