package 終極密碼多AI;

import java.util.*;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		scanner = new Scanner(System.in);
		GuessGame game = GuessGame.getInstance();
		int playerAmount;
		int aiOddAmount;
		int aiEvenAmount;
		
		System.out.println("輸入幾位玩家: ");
		playerAmount = scanner.nextInt();scanner.nextLine();
		System.out.println("輸入幾位奇數型電腦玩家: ");
		aiOddAmount = scanner.nextInt();scanner.nextLine();
		System.out.println("輸入幾位偶數型電腦玩家: ");
		aiEvenAmount = scanner.nextInt();scanner.nextLine();
		
		for ( int i = 0 ; i < playerAmount ; i ++ )  // adding three kinds of Player
		{
			System.out.println("輸入玩家"+(i+1)+"名稱：");
			String name = scanner.nextLine();
			players.add(new HumanPlayer(name));
		}
		
		for ( int i = 0 ; i < aiOddAmount ; i ++ )
			players.add(new AI_Odd());
		for ( int i = 0 ; i < aiEvenAmount ; i ++ )
			players.add(new AI_Even());
		
		for ( int time = 0 ; time < 10 ; time ++ ) //洗牌10次
			for ( int i = 0 ; i < players.size() ; i ++ )  // 洗牌演算法
			{
				int index = new Random().nextInt(players.size());
				Player temp = players.get(i);  //swap
				players.set(i,players.get(index));
				players.set(index,temp);
			}
		
		System.out.println("順序為 : ");
		for ( Player p : players )
			System.out.print(p + "\n");
		System.out.println();
		do  // game starts
		{
			boolean available;
			for ( int i = 0 ; i < players.size() && !game.isOver() ; i ++ )
			{
				//延遲1秒
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
				do{
					System.out.println(game.getStateMessage());  //印出範圍狀況
					available = game.doGuessingAction(players.get(i));  //將遊戲者傳入遊戲中進行猜數字，回傳該數字是否可行
					if (!available)
						System.out.println("輸入錯誤，請輸入在範圍內。");
				}while (!available);  //防呆
			}
		}while( !game.isOver());

	}

}
