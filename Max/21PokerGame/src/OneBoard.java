
public class OneBoard {
	private int point;
	private String name;
	private int rank;
	public OneBoard(String name , int point){
		this.name = name;
		this.point = point;
		rank = 0;
	}
	public void setCardPoint(int point){
		this.point = point;
	}
	public int getCardPoint(){
		return point;
	}
	public void setBoardName(String name){
		this.name = name;
	}
	public String getBoardName(){
		return name;
	}
	public void addBoardRankPoint(int r){
		this.rank += r;
	}
	public int getBoardRankPoint(){
		return rank;
	}
}
