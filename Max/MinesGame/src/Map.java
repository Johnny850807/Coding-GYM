import java.util.Random;

public class Map {
	private int mapSize;
	private int mineCount;
	private Ground[][] ground;
	
	public Map(int size,int mine){
		mapSize = size;
		mineCount = mine;
		ground = new Ground[size][size];
		setGround();
		randomMine();
		countMapMine();
	}
	
	
	public void setGround(){
		for (int i = 0 ; i < mapSize; i++){
			for (int j = 0 ; j < mapSize; j++){
				ground[i][j] = new Ground();
			}
		}
	}
	public void randomMine(){
		int count = 0;
		int x , y;
		boolean check = false;
		while (!check){
			x = new Random().nextInt(mapSize);
			y = new Random().nextInt(mapSize);
			if(ground[x][y].isMine() == false){
				ground[x][y].setMine(true);
				ground[x][y].setRoundMine(-1);
				count++;
				if(count == mineCount)
					check = true;
			}
			else
				continue;
				
		}
	}
	public void countMapMine(){
		for (int i = 0 ; i < mapSize; i++){
			for (int j = 0 ; j < mapSize; j++){
				if(ground[i][j].isMine() == true){
					for (int k = -1 ; k < 2; k++){
						for (int l = -1 ; l < 2; l++){
							if ( i+k >= 0 && j+l >= 0 && i+k < mapSize && j+l < mapSize && ground[i+k][j+l].isMine() != true )
								ground[i+k][j+l].addRoundMine(1);
						}
					}
				}
			}
		}
	}
	public void printMap(){
		for (int i = 0 ; i < mapSize; i++){
			for (int j = 0 ; j < mapSize; j++){
				if(ground[i][j].isOpen() == true)
					ground[i][j].printGround();
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
	public boolean playerChoicOpen(int x , int y){
		if(ground[x][y].isMine() == true){
			printOpenGround();
			System.out.println("你翻到地雷了~嗚嗚");
			return true;
		}
			
		else{
			ground[x][y].setOpen(true);
			printMap();
			return false;
		}
			
	}
	private void printOpenGround(){
		for (int i = 0 ; i < mapSize; i++){
			for (int j = 0 ; j < mapSize; j++){
				System.out.print(ground[i][j].getRoundMine() + " ");
			}
			System.out.println();
		}
	}
	
}
