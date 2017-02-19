package built_in;

public abstract class MovingItem {
	protected int x = 0;  //座標x
	protected int y = 0;  //座標y
	protected int mapSize;
	public MovingItem(int mapSize){
		this.mapSize = mapSize;
	}
	public abstract char getSign();  //得到此物件的代表字元 (用於輸出)
	public abstract int getMovingStep();  // 得到此物件每次移動距離
	
	public void walkNorth(){
		y -= getMovingStep();
		checkCoordinateBounded();
	}
	
	public void walkSouth(){
		y += getMovingStep();
		checkCoordinateBounded();
	}

	public void walkEast(){
		x += getMovingStep();
		checkCoordinateBounded();
	}

	public void walkWest(){
		x -= getMovingStep();
		checkCoordinateBounded();
	}
	
	private void checkCoordinateBounded(){
		if ( y < 0 )
			y = 0;
		if ( y >= mapSize )
			y = mapSize - 1;
		if ( x < 0 )
			x = 0;
		if ( x >= mapSize )
			x = mapSize - 1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
