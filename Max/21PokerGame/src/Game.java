import java.util.*;

public class Game {
	private CardPile cardpile;
	private RankBoard rankboard = new RankBoard();
	private int humanAmout;
	private int aiAmout;
	private String name;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Game(){
		setGame();
		startGame();
	}
	public void initial(){
		cardpile = new CardPile();
	}
	public void setGame(){
		Scanner scanner = new Scanner(System.in); 
		System.out.println("設置玩家數量 (建議 1人) :");
		humanAmout = scanner.nextInt();
		System.out.println("設置電腦數量(建議5人) :");
		aiAmout = scanner.nextInt();
		for (int i = 0 ; i < humanAmout; i++){
			System.out.println("輸入玩家" + (i+1) +"的名字  :");
			name = scanner.next();
			players.add(new Human(name));
		}
		for (int i = 0 ; i < aiAmout; i++){
			players.add(new AI("忠"+Integer.toString(i)+"號"));
		}
		 
		 randomPlayer();
		 for (Player player: players){
	        	System.out.println("第  " + players.indexOf(player) + " 位玩家為 : " +player.getName());
	        }
	}
	private void randomPlayer(){
		for ( int time = 0 ; time < 10 ; time ++ ) 
			for ( int i = 0 ; i < players.size() ; i ++ )  
			{
				int index = new Random().nextInt(players.size());
				Player temp = players.get(i);  
				players.set(i,players.get(index));
				players.set(index,temp);
			}
	}
	public void startGame(){
		boolean stop = false;
		Card cardtemp;
		int totpoint;
		for (int i =0 ; i < 3; i++){
			initial();
			System.out.println("第 " + Integer.toString(i+1) + " 回合開始");
			for(Player player:players){
				System.out.println("輪到 " + player.getName() +" 了!!");
				totpoint = 0;
				do{
					try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
					cardtemp = cardpile.getCard();
					System.out.println("翻開了 ------- " + cardtemp.getCardType() +
							cardtemp.getCardPoint() );
					stop = player.playGame(cardtemp);
					if(player.getTotPoint() > 21){
						System.out.println("爆了拉!!!!!!!!!!!!");
						stop = true;
					if(cardpile.checkHasCard() == false){
						System.out.println("沒牌了喔~~~結束這回合");
						stop = true;
					}
					}
				}while(!stop);
				totpoint = player.getTotPoint();
				System.out.println(player.getName() + "得到 " + totpoint + "分");
				rankboard.addOnRankBoard(player.getName(), player.getTotPoint());
				
				player.initial();
			}
			rankboard.selectWinner();
			rankboard.sortRank();
		}
		
	}
}
