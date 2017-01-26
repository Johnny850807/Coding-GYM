package 撲克牌21點示範;

import java.util.*;

public class Game21Point {
	private ArrayList<Player> playerList;
	private ArrayList<Player> rankList;
	private DeckStack deck;
	private DeckStack discards;
	private ConfigurationToGame config;
	
	public Game21Point(ConfigurationToGame config){
		this.config = config;
		resetGame();
	}
	
	public void resetGame(){
		config.doAllSettingInput();
		playerList = config.getShuffledPlayerListAndPrintOrder();
		deck = config.getDeck();
		discards = config.getDiscards();
		rankList = new ArrayList<Player>();
	}
	
	public void startGame(){
		allRoundsUntillThreeRounds();
	}
	
	public void allRoundsUntillThreeRounds(){
		for ( int i = 0 ; i < 3 ; i ++ )
		{
			System.out.printf("第 %d 回合開始!! %n",i+1);
			oneRoundProcess();
		}

		settleFinalWinner();
	}
	
	private void oneRoundProcess(){
		inTurnAllPlayersProcess();
		settleWinnerInRound();
		resetRoundPointOfAllPlayers();
	}
	
	public void inTurnAllPlayersProcess(){
		for ( Player p : playerList)
			onePlayerAction(p);
	}
	
	public void onePlayerAction(Player player){
		boolean choice;
		int curPoint = 0;
		System.out.printf("輪到 %s 了 !! %n",player);
		do
		{
			reShuffleIfDeckEmpty();
			curPoint += showNextCardAndGetItsPoint();
			if ( curPoint > 21 )
				break;
			choice = player.makeChoiceProcess();
		} while(choice);
		
		setAndPrintRoundPlayeScoreGet(player,curPoint);
	}
	
	private int showNextCardAndGetItsPoint(){
		Card card = deck.pop();
		discards.add(card);
		System.out.printf("翻開了 ....  %s%n",card);
		delay();
		return card.getPoint();
	}
	
	public void reShuffleIfDeckEmpty(){
		delay();
		if ( deck.empty() )
			reShuffle();
	}
	
	private void reShuffle(){
		System.out.println("========洗牌中========");
		discards.shuffleTenTimes();
		deck.addAll(discards);
		discards.clear();
		delay();
	}
	
	private void setAndPrintRoundPlayeScoreGet(Player player , int point){
		delay();
		point = point > 21 ? 0 : point;
		System.out.printf("%s 得到了 .. %d分%n",player,point);
		player.setRoundScore(point);
	}
	
	private void settleWinnerInRound(){
		orderPlayerRankListByComparator( new OneRoundWinnerComparatorImp() );
		printWinnerInOneRound();
	}
	
	private void printWinnerInOneRound(){
		Player winner = rankList.get(0);
		System.out.printf("此回合由 %s 得到一分 !! %n", winner);
		delay();delay();
		winner.setFinalGameScore( winner.getFinalGameScore()+1);
	}
	
	private void settleFinalWinner() {
		orderPlayerRankListByComparator(new FinalWinnerComparatorImp());
		Player winner = rankList.get(0);
		printFinalRanks();
	}
	
	private void orderPlayerRankListByComparator(Comparator comparator){
		rankList.clear();
		rankList.addAll(playerList);
		rankList.sort( comparator);
	}
	
	private void printFinalRanks(){
		System.out.println("遊戲結束!!!!!!");
		for ( int i = 0 ; i < rankList.size() ; i ++ )
			System.out.printf("第%d名 -- %s%n", i+1 , rankList.get(i) );
	}

	private void delay(){
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	private void resetRoundPointOfAllPlayers(){
		for ( Player p : playerList)
			p.setRoundScore(0);
	}
	

	private final class OneRoundWinnerComparatorImp implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			Player p1 = (Player)o1;
			Player p2 = (Player)o2;
			
			if ( p1.getRoundScore() > p2.getRoundScore() ) 
				return -1;
			if ( p1.getRoundScore() == p2.getRoundScore() )
				if (p1.getPriority() > p2.getPriority())
					return -1;
			return 1;
		}
	}
	
	private final class FinalWinnerComparatorImp implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			Player p1 = (Player)o1;
			Player p2 = (Player)o2;
			
			if ( p1.getFinalGameScore() > p2.getFinalGameScore() ) 
				return -1;
			if ( p1.getRoundScore() == p2.getRoundScore() )
				if (p1.getPriority() > p2.getPriority())
					return -1;
			return 1;
		}
	}
	
	
	
	
}
