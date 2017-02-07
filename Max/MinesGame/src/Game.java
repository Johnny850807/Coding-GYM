import java.util.*;

public class Game {
	private int mapSize;
	private int mineCount;
	private int playerInput_X;
	private int playerInput_Y;
	private Map map; 
	private boolean gameOver;
	public Game(){
		setSize();
		setMine();
		startGame();
	}
	private void setSize(){
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("請輸入地圖大小(1~10) :");
			mapSize = scanner.nextInt();
			System.out.println(mapSize);
			if (mapSize > 10 || mapSize < 1 ){
				System.out.println("請輸入範圍內的大小");
				continue;
			}
			else
				break;	
		}
	}
	private void setMine(){
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("請輸入地雷數量(1~size*size) :");
			mineCount = scanner.nextInt();
			System.out.println(mineCount);
			if (mineCount > mapSize*mapSize || mineCount < 1 ){
				System.out.println("請輸入範圍內的地雷數量");
				continue;
			}
			else
				break;	
		}
	}
	public void startGame(){
		map = new Map(mapSize , mineCount);
		map.printMap();
		while(!gameOver){
			Scanner scanner = new Scanner(System.in);
			System.out.println("請輸入欲選擇格子座標(y/x) :");
			playerInput_Y = scanner.nextInt();
			playerInput_X = scanner.nextInt();
			gameOver = map.playerChoicOpen(playerInput_X, playerInput_Y);
		}
	}
	
}
