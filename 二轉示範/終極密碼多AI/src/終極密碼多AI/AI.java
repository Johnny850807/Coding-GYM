package ²×·¥±K½X¦hAI;

public abstract class AI extends Player{
	private static int amount = 0;
	
	public AI(){
		amount++;
	}
	
	@Override
	protected String nameSelf() {
		return "AI " + String.valueOf(amount++);
	}

}
