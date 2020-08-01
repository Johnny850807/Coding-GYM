import card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardFightSystem {
    private Stack<Card> cardDeck = new Stack<>();
    private List<Player> players = new ArrayList<>();
    private int playerWinRound = 0;
    private int opponentWinRound = 0;

    public CardFightSystem() {
        initialization();
    }

    public void gameStart() {
        Card playerSelectCard;
        Card opponentSelectCard;

        for (Player player : players) {
            player.setHandCards(dealCards());
        }
        for (int j = 0; j < 3; j++) {
            playerSelectCard = players.get(0).playCard();
            opponentSelectCard = players.get(1).playCard();
            DuelResult duelResult = playerSelectCard.duel(opponentSelectCard);

            switch (duelResult) {
                case WIN:
                    playerWinRound++;
                    System.out.println(players.get(0).getName() + " 在此輪比賽獲勝了");
                    break;
                case LOSE:
                    opponentWinRound++;
                    System.out.println(players.get(1).getName() + " 在此輪比賽獲勝了");
                    break;
                case TIE:
                    System.out.println(" 雙方在此輪比賽平手了");
                    break;
            }
        }
    }

    public void initialization() {
        for (int i = 0; i < 3; i++) {
            cardDeck.push(new GeneralCard());
        }
        for (int i = 0; i < 5; i++) {
            cardDeck.push(new KnightCard());
        }
        for (int i = 0; i < 7; i++) {
            cardDeck.push(new InfantryCard());
        }
        for (int i = 0; i < 6; i++) {
            cardDeck.push(new SoldierCard());
        }

        Collections.shuffle(cardDeck);
    }

    public List<Card> dealCards() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cardList.add(cardDeck.pop());
        }
        return cardList;
    }

    public Player getWinner() {
        if (playerWinRound > opponentWinRound) {
            return players.get(0);
        } else {
            return players.get(1);
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
