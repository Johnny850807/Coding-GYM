package built_in;

public class Tank extends MovingItem{

	public Tank(int mapSize) {
		super(mapSize);
	}

	@Override
	public char getSign() {
		return 'o';
	}

	@Override
	public int getMovingStep() {
		return 2;
	}

}
