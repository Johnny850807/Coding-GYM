package ²×·¥±K½X¦hAI;

public abstract class Player {
	protected GuessGame game = GuessGame.getInstance();
	protected PlayerType type; 
	protected String name;
	protected int id;
	public static int playerAmount = 0;
	public Player(PlayerType type , String name){
		this.type = type;
		this.name = name;
		this.id = ++playerAmount;
	}
	@Override
	public String toString() {
		return String.format("-%s %d  %s-", type , id , name);
	}
	public String getGuessMessage(int guess){
		return String.format("%s ²q¤F¼Æ¦r  %d%n" , this , guess );
	}
	public int doGuessingAction(){
		int guess = getGuessingNumber();
		getGuessMessage(guess);
		return guess;
	}
	public abstract int getGuessingNumber();
	
	public PlayerType getType() {
		return type;
	}
	public void setType(PlayerType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
