package Furniture;

public class Light {
	private boolean turn = false;
	
	public void turnOn(){
		System.out.println("�}�ҹq�O");
		turn = true;
	}
	
	public void turnOff(){
		System.out.println("�����q�O");
		turn = false;
	}
	
	public boolean isTurnOn(){
		return turn;
	}
}
