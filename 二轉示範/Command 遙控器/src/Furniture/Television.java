package Furniture;

public class Television {
	private int program = 0;
	
	public void changeProgram(int number){
		System.out.println("�����W�D : " + number);
		this.program = number;
	}

	public int getProgramNumber() {
		return program;
	}

}
