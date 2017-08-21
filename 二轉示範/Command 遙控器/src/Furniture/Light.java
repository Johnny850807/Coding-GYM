package Furniture;

public class Light {
	private boolean turn = false;
	
	public void turnOn(){
		System.out.println("開啟電燈");
		turn = true;
	}
	
	public void turnOff(){
		System.out.println("關閉電燈");
		turn = false;
	}
	
	public boolean isTurnOn(){
		return turn;
	}
}
