package players;

import players.decisions.Decision;
import stocks.Order;
import stocks.Order.Type;
import utils.Input;

public class HumanPlayer extends Player {

    @Override
    public String nameSelf() {
        return Input.nextLine("請輸入名稱: ");
    }

    @Override
    public Decision makeDecision(Decision buyStocks, Decision sellStocks, Decision completeTurn) {
        return Input.nextDecision(buyStocks, sellStocks, completeTurn);
    }

    @Override
    public Order chooseWhichStockToBuy() {
        int stockId = Input.nextInt("請輸入股票Id: ");
        int amount = Input.nextInt("請輸入購買數量: (1~10)", 1, 10);
        return new Order(this, stockId, amount, Type.BUY);
    }

    @Override
    public Order chooseWhichStockToSell() {
        int stockId = Input.nextInt("請輸入股票Id: ");
        int amount = Input.nextInt("請輸入販賣數量: (1~10)", 1, 10);
        return new Order(this, stockId, amount, Type.SELL);
    }

}
