package Game;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Exception.CashFlowException;
import Exception.NoStockException;
import Player.Player;
import Stock.Order;
import Stock.StockMarket;
import Stock.StockProduct;

public class CashFlowGame implements Serializable {
	private final static int SELL_ACTION = 1;
	private final static int BUY_ACTION = 2;
	private final static int LEAVE_ACTION = 3;
	
	private CashFlowGameSaveManager saveManager;
	private Date gameDate;
	private StockMarket market;
	private List<Player> players = new ArrayList<>();
	private List<Player> rank = new ArrayList<>();
	private int turn = 0; //輪到誰
	
	public CashFlowGame(CashFlowGameSaveManager saveManager){
		this.saveManager = saveManager;
	}
	
	private CashFlowGame configGame(){
		GameConfiguration config = new GameConfiguration();
		market = config.createMarket();
		players = config.createPlayers(market);
		return this;
	}
	
	public void start() throws InterruptedException, ClassNotFoundException, IOException{
		
		while (!isGameOver())
		{
			try
			{
				runOneDay();
				delay();
			}catch(CashFlowException err){
				System.out.println(err.getMessage());
				onPlayerChooseOptionResume(err.getErrorPlayer());
			}
		}
		onGameOver();
	}
	
	private void onPlayerChooseOptionResume(Player errorPlayer) throws InterruptedException{
		try{
			onPlayerChooseOption(errorPlayer);
		}catch(CashFlowException err){
			System.out.println(err.getMessage());
			onPlayerChooseOptionResume(errorPlayer);
		}
	}
	
	private boolean isGameOver(){
		for ( Player player : players )
			if (!player.isWin())
				return false;
		return true;
	}
	
	private void runOneDay() throws InterruptedException, ClassNotFoundException, IOException{
		turn = 0;
		while(turn < players.size())
		{
			onPlayerChooseOption(players.get(turn));
			turn ++;
		}	
		market.newDay();
		saveManager.saveGame(this);
	}
	
	private void onPlayerChooseOption(Player player) throws InterruptedException{
		int option;
		do
		{
			System.out.println(player.toString());
			System.out.println("請選擇 (1) 賣股票 (2) 購買股票 (3) 結束回合");  delay();
			option = player.chooseActionOption();
			onOptionAction(player, option);   delay();
			detectPlayerIsWin(player);
		} while(option != 3 && !player.isWin());
	}
	
	private void onOptionAction(Player player, int option) throws InterruptedException{
		Order order = null;
		delay();
		switch(option)
		{
		case SELL_ACTION:
			order = getPlayerSellOrder(player);
			break;
		case BUY_ACTION:
			order = getPlayerBuyOrder(player);
			break;
		case LEAVE_ACTION:
			return ;
		}
		delay();
		StockProduct product = market.executeOrder(order);
		player.receiveStockProduct(product);
		delay();
	}
	
	private Order getPlayerSellOrder(Player player){
		System.out.println(player.stocksToString());
		if (player.hasStocks())
			return player.chooseWhichStockToSell();
		throw new NoStockException(player);
	}
	
	private Order getPlayerBuyOrder(Player player){
		market.display();
		return player.chooseWhichStockToBuy();
	}
	
	private void detectPlayerIsWin(Player player){
		if (player.isWin())
		{
			System.out.println(player.getName() + " 已達成勝利條件 !");
			players.remove(player);
			rank.add(player);
		}
	}
	
	private void onGameOver(){
		saveManager.clearSave();
		printRankList();
	}
	
	public void printRankList(){
		System.out.println("遊戲結束 !!!!!!");
		
		for (int i = 0 ; i < rank.size() ; i ++ )
			System.out.println("第" + (i+1) + "名 : " + rank.get(i).getName());
	}
	
	private void delay() throws InterruptedException{
		//Thread.sleep(50);
	}
	
	public static void main(String[] argv){
		try {
			CashFlowGameSaveManager saveManager = new CashFlowGameSaveManager();
			if (saveManager.hasGameSave())
				saveManager.loadGame().start();
			saveManager.startNewGame().configGame().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

