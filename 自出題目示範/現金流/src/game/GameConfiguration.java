package game;

import players.HumanPlayer;
import players.Player;
import players.StupidAI;
import stocks.factories.StockMarketFactory;
import stocks.factories.StockMarketFactoryImp;
import stocks.StockMarket;
import utils.Input;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
    private StockMarketFactory factory = new StockMarketFactoryImp();

    public StockMarket createMarket() {
        return factory.createMarket();
    }

    public List<Player> createPlayers(StockMarket market) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            players.add(createPlayer(i, market));
        }
        return players;
    }

    private Player createPlayer(int number, StockMarket market) {
            int type = Input.nextInt("請選擇玩家 " + number + " 類型 :(1) 人類玩家 (2) 電腦: ", 1, 2);

        switch (type) {
            case 1:
                return new HumanPlayer();
            case 2:
                return new StupidAI(market);
            default:
                throw new UnsupportedOperationException("目前還不支援");
        }
    }
}
