package presenters;

import controllers.CashflowGameController;
import controllers.decisions.BuyStockDecision;
import controllers.decisions.CompleteTurnDecision;
import controllers.decisions.Decision;
import controllers.decisions.SellStockDecision;
import players.Player;
import utils.Input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class CommandLinePresenter implements CashflowGameController.Listener {
    @Override
    public void onGameStarted() {
        System.out.println(emphasize("遊戲開始囉"));
    }

    @Override
    public void onPlayerTurn(Player player) {
        System.out.println(emphasize("輪到 " + player));
    }

    @Override
    public Decision onMakeDecision(BuyStockDecision buyStockDecision, SellStockDecision sellStockDecision, CompleteTurnDecision completeTurnDecision) {
        int choice = Input.nextInt("請選擇 (1) 販賣股票 (2) 購買股票 (3) 結束回合 ", 1, 3);
        switch (choice) {
            case 1:
                return makeBuyStocksDecision(buyStockDecision);
            case 2:
                return makeSellStocksDecision(sellStockDecision);
            default:
                return completeTurnDecision;
        }
    }

    private Decision makeBuyStocksDecision(BuyStockDecision buyStockDecision) {
        System.out.println(emphasize("股票列表"));
        buyStockDecision.getStocks().forEach(System.out::println);
        int stockId = Input.nextInt("請選擇欲購買之股票Id: ", buyStockDecision.getAllStockIds());
        int amount = Input.nextInt("請輸入欲購買張數 (1~10): ", 1, 10);
        buyStockDecision.setStockId(stockId);
        buyStockDecision.setAmount(amount);
        return buyStockDecision;
    }

    private Decision makeSellStocksDecision(SellStockDecision sellStockDecision) {
        System.out.println(emphasize("玩家持有股票列表"));
        sellStockDecision.getOwnStocks().forEach(System.out::println);
        int stockId = Input.nextInt("請選擇欲販賣之股票Id: ", sellStockDecision.getAllOwnStockIds());
        int amount = Input.nextInt("請輸入欲販賣張數 (1~10): ", 1, 10);
        sellStockDecision.setStockId(stockId);
        sellStockDecision.setAmount(amount);
        return sellStockDecision;
    }

    @Override
    public void onGameOver(List<Player> winnersInRank) {
        System.out.println(IntStream.range(0, winnersInRank.size())
                .mapToObj(idx -> String.format("第%d名 %s", idx, winnersInRank.get(idx).getName()))
                .collect(Collectors.joining("\n")));
    }

    @Override
    public void onDayBegins() {
        System.out.println(emphasize("新的一天"));
    }

    private String emphasize(final String text) {
        return String.format("======== %s ========", text);
    }

    @Override
    public void onDayEnds() { }
}
