package 撲克牌21點示範;

import java.util.*;

import Player.Player;
import PokeCard.Card;
import PokeCard.DeckStack;

public class Game21Point {
	public final static int MAX_POINT = 21;
	private ArrayList<Player> playerList;
	private DeckStack deck;  //牌堆
	private DeckStack discards;  //棄牌區
	private ConfigurationToGame config;  //遊戲設置
	
	public Game21Point(ConfigurationToGame config){
		this.config = config;
		resetGame();
	}
	
	//對遊戲設置進行呼叫以及取得所有資源
	public void resetGame(){
		config.doAllSettingInput();
		playerList = config.getShuffledPlayerListAndPrintOrder();
		deck = config.getDeck();
		discards = config.getDiscards();
	}
	
	public void startGame(){
		runThreeRoundsGame();
	}
	
	public void runThreeRoundsGame(){
		for ( int i = 0 ; i < 3 ; i ++ )
		{
			System.out.printf("第 %d 回合開始!! %n",i+1);
			oneRoundProcess();
		}

		printFinalRanks();  //印出結果
	}
	
	//每回合21點撲克牌
	private void oneRoundProcess(){
		inTurnAllPlayersProcess();    //每個玩家輪流
		settleWinnerInRound();  //決定該輪勝者並增加分數
		resetRoundPointOfAllPlayers();  //清理乾淨這場的數據
	}
	
	public void inTurnAllPlayersProcess(){
		for ( Player p : playerList)
			onePlayerAction(p);
	}
	
	//一個玩家的回合
	public void onePlayerAction(Player player){
		boolean choice;
		System.out.printf("輪到 %s 了 !! %n",player);
		do
		{
			reShuffleIfDeckEmpty();  //如果沒牌就重新洗牌
			getNextCard(player);  //不然就抽出下一張卡並得到分數
			if ( player.isHandCardsOutOfBount() )  //如果超過範圍就離開
				break;
			choice = player.makeChoiceProcess();  //不然做決定 是否再要一張
		} while(choice);
		
		printRoundResult(player);  //印出此回合結果
	}
	
	private void getNextCard(Player player){
		Card card = deck.pop();  //抽牌
		discards.add(card);  //放入棄牌區
		player.addHandCard(card);  //放進手牌
		System.out.printf("翻開了 ....  %s%n",card);
		delay();
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
	
	private void printRoundResult(Player player){
		delay();
		int point = player.isHandCardsOutOfBount() ? 0 : player.getHandCardsPoint();
		System.out.printf("%s 得到了 .. %d分%n",player,point);
	}
	
	private void settleWinnerInRound(){
		Player winner = getRoundWinnter();	//計算這回合的勝利者
		printAndRewardWinner(winner);  //並且印出以及增加該勝利者分數
	}

	private Player getRoundWinnter(){
		int maxScore = -99;
		Player winner = null;
		for ( Player player : playerList )
		{
			int score = player.getHandCardsPoint();
			if ( score > maxScore )
			{
				maxScore = score;
				winner = player;
			}
		}
		return winner;
	}
	
	private void printAndRewardWinner(Player winner){
		System.out.printf("此回合由 %s 得到一分 !! %n", winner);  
		winner.win();  //勝利並拿分
		delay();delay();
	}
	
	private void printFinalRanks(){
		Collections.sort(playerList, new FinalWinnerComparatorImp());  //用自製排序規則排序Player串列，使他照著分數高低排
		System.out.println("遊戲結束!!!!!!");
		for ( int i = 0 ; i < playerList.size() ; i ++ )
			System.out.printf("第%d名 -- %s%n", i+1 , playerList.get(i) );
	}

	//延遲
	private void delay(){
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	//清理所有手牌
	private void resetRoundPointOfAllPlayers(){
		for ( Player p : playerList)
			p.clearHandCards();
	}
	
	//負責定義排序規則的類別 
	private final class FinalWinnerComparatorImp implements Comparator<Player> {
		@Override
		public int compare(Player p1, Player p2) {  
			if ( p1.getScore() == p2.getScore() )  //分數一樣就回傳 0  象徵 等於
				return 0;
			if ( p1.getScore() > p2.getScore() )
				return -1;  
			return 1;
		}
	}
	
}
