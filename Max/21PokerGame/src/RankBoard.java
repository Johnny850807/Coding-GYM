import java.util.*;

public class RankBoard {
	private ArrayList<OneBoard> rank ;
	final int bingo = 21; 
	public RankBoard(){
		rank = new ArrayList<OneBoard>();
	}
	public void addOnRankBoard(String n , int p){
		boolean s = false;
		if(rank.size() == 0){
			rank.add(new OneBoard(n,p));
		}
		for(OneBoard r : rank){
			if(r.getBoardName() == n){
				r.setCardPoint(p);
				s = true;
			}
		}
		if(!s){
			rank.add(new OneBoard(n,p));
		}	
	}
	public ArrayList getRankBoard(){
		return rank;
	}
	public void selectWinner(){
		boolean havewinner = false;
		for(int i = 0 ; i <= 21 && !havewinner; i++){
			for(OneBoard r :rank){
				if( bingo - r.getCardPoint() == i){
					System.out.println("此回合由 " + r.getBoardName() +" 1得分!!");
					r.addBoardRankPoint(1);
					havewinner = true;
					break;
				}
			}
		}
	}
	public void sortRank(){
		int times = 1;
		for (int i = 2 ; i >=0; i--)
			for (OneBoard r : rank){
				if( r.getBoardRankPoint() == i ){
					System.out.println("第 " + times++ + " 名是 " + r.getBoardName());
				}
			}
	}
	public void getRankPoint(){
		for(OneBoard r:rank){
			System.out.println(r.getBoardName() + " " +r.getBoardRankPoint());
		}
	}
}
