package Game;

import java.util.ArrayList;
import java.util.List;

import Player.GodAI;
import Player.HumanPlayer;
import Player.Player;
import Player.StupidAI;
import Stock.StockMarket;
import Stock.Factory.StockMarketFactory;
import Stock.Factory.StockMarketFactoryImp;
import Util.Input;

public class GameConfiguration {
	private StockMarketFactory factory = new StockMarketFactoryImp();
	
	public StockMarket createMarket() {
		return factory.createMarket();
	}

	public List<Player> createPlayers(StockMarket market){
		List<Player> players = new ArrayList<>();
		for ( int i = 0 ; i < 4 ; i ++ )
			players.add(createPlayer(i, market));
		return players;
	}

	private Player createPlayer(int number, StockMarket market) {
		int type = Input.nextInt("��J���a" + number + " ���� :(1) �u�H (2) �¹q��  (3) ���q��", 1, 3);

		switch(type)
		{
		case 1:
			return new HumanPlayer();
		case 2:
			return new StupidAI(market);
		default:
			return new GodAI(market);
		}
	}
}
