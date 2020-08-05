package players;

import exception.MoneyNotEnoughException;
import exception.StockNotEnoughException;
import players.decisions.Decision;
import stocks.Order;
import stocks.Stock;
import stocks.StockProduct;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Player implements Serializable {
    protected Map<Stock, Integer> stocks = new HashMap<>();  // key: stock value: amount
    protected String name;
    protected int money = 6000;

    public Player() {
        name = nameSelf();
    }

    public abstract String nameSelf();

    public void receiveStockProduct(StockProduct product) {
        alterStockAmount(product.getStock(), product.getAmount());
        alterMoneyByTransactionCost(product.getCost());
        System.out.println(name + " " + product);
    }

    public void alterStockAmount(Stock stock, int amount) {
        int currentAmount = stocks.get(stock) == null ? 0 : stocks.get(stock);
        int resultAmount = currentAmount + amount;
        if (resultAmount < 0)
            throw new StockNotEnoughException(stock);
        stocks.put(stock, resultAmount);
        if (stocks.get(stock) == 0)
            stocks.remove(stock);
    }

    private void alterMoneyByTransactionCost(int cost) {
        int resultMoney = money - cost;
        if (resultMoney < 0)
            throw new MoneyNotEnoughException();
        money -= cost;
    }

    public boolean hasStocks() {
        return stocks.size() != 0;
    }

    public abstract Decision makeDecision(Decision buyStocks, Decision sellStocks, Decision completeTurn);

    public abstract Order chooseWhichStockToBuy();

    public abstract Order chooseWhichStockToSell();

    public String stocksToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-- 玩家 ").append(name).append(" 之股票列表 --\n");
        for (Stock stock : stocks.keySet())
            stringBuilder.append(String.format("(%d) %s %d張 %n",
                    stock.getId(), stock.getName(), stocks.get(stock)));
        return stringBuilder.toString();
    }

    public boolean isWin() {
        return money >= 10000;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("玩家 %s %n 持有現金: %d %n", name, money);
    }

}
