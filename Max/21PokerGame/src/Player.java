
public abstract class Player {
	
	protected PlayerTypeEnum playerType; 
	protected String name;
	protected boolean pointOver;
	private int rankpoint;
	public Player(PlayerTypeEnum playertype , String name){
		playerType = playertype;
		this.name = name;
		rankpoint = 0;
	}
	public PlayerTypeEnum getType() {
		return playerType;
	}
	public void setType(PlayerTypeEnum playertype) {
		playerType = playertype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addRankPoint(int p){
		rankpoint += 1;
	}
	public int getRankPoint(){
		return rankpoint;
	}
	public abstract void initial();
	public abstract int getTotPoint();
	public abstract boolean playGame(Card card);
	
}
