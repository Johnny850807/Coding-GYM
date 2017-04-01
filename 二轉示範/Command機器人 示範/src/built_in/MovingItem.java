package built_in;

public abstract class MovingItem {
	protected int x = 0;  //�y��x
	protected int y = 0;  //�y��y
	protected int mapSize;
	public MovingItem(int mapSize){
		this.mapSize = mapSize;
	}
	public abstract char getSign();  //�o�즹���󪺥N��r�� (�Ω��X)
	public abstract int getMovingStep();  // �o�즹����C�����ʶZ��
	
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
