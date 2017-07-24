package ²×·¥±K½X¦hAI;

public class Test {
	public static void main(String[] argv){
		Player player = new Player(PlayerType.PLAYER,"Name"){
			@Override
			protected int getGuessingNumber() {
				return 50;
			}
		};
	}
}