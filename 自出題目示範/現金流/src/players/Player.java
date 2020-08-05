package players;

import exception.MoneyNotEnoughException;
import exception.StockNotEnoughException;
import exception.StockNotFoundException;
import stocks.Stock;

import java.util.*;

public class Player {
    // key: stock value: amount
    protected final Set<OwnStock> ownStocks = new TreeSet<>(Comparator.comparingInt(OwnStock::getCurrentPrice));
    private int id;
    protected final String name;
    protected int money = 6000;

    public Player(String name) {
        this.name = name;
    }

    public void addStocks(Stock stock, int amount) {
        OwnStock ownStock = findOwnStock(stock)
                .orElseGet(() -> new OwnStock(stock, amount));
        ownStock.setAmount(ownStock.getAmount() + amount);
    }

    public void consumeStocks(Stock stock, int amount) throws StockNotFoundException, StockNotEnoughException {
        OwnStock ownStock = findOwnStock(stock)
                .orElseThrow(() -> new StockNotFoundException(
                        String.format("Player %s doesn't own the stock %s.", name, stock.getName())));

        if (ownStock.getAmount() < amount) {
            throw new StockNotEnoughException(stock, amount);
        }
        int remainingAmount = ownStock.getAmount() - amount;
        if (remainingAmount == 0) {
            ownStocks.remove(ownStock);
        } else {
            ownStock.setAmount(remainingAmount);
        }
    }

    public Collection<OwnStock> getOwnStocks() {
        return ownStocks;
    }

    public void costMoney(int cost) {
        if (money < cost) {
            throw new MoneyNotEnoughException();
        }
        money -= cost;
    }

    private Optional<OwnStock> findOwnStock(Stock stock) {
        return ownStocks.stream()
                .filter(o -> stock == o.getStock())
                .findFirst();
    }

    public boolean hasStock(Stock stock) {
        return ownStocks.stream()
                .anyMatch(o -> o.getStock() == stock && o.getAmount() > 0);
    }

    public boolean hasStocks() {
        return ownStocks.size() != 0;
    }


    public boolean isWin() {
        return money >= 10000;
    }


    public String getName() {
        return name;
    }


    public int getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("玩家 %s %n (持有現金: %d)", name, money);
    }

    public void gainMoney(int gainedMoney) {
        money += gainedMoney;
    }
}
