package built_in;

import client.MyMap;

public class Robot extends MovingItem{
	
	public Robot(int mapSize) {
		super(mapSize);
	}

	@Override
	public char getSign() {
		return '*';
	}

	@Override
	public int getMovingStep() {
		return 1;
	}
	
	
}
