package �G�Q�@�I���J�P�C��;

import java.util.Random;

public class AI extends Player {
	private static int amount = 0;
	
	@Override
	protected String nameSelf() {
		String[] ComputerName = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		name = "�q��" + ComputerName[amount++];
		return name;
	}

	@Override
	protected boolean needCard(int score) {
		if (score > 15) {
			System.out.println("n");
			return false;
		}
		else {
			System.out.println("y");
			return true;
		}
	}

	

}
