import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BlackJack {
    private List<Player> players = new ArrayList<>();
    private Stack<Card> cardDeck = new Stack<>();
    private Stack<Card> throwCardDeck = new Stack<>();
    private FinalScoreComparator finalScoreComparator = new FinalScoreComparator();
    private RoundScoreComparator roundScoreComparator = new RoundScoreComparator();

    public BlackJack() {
        initializationCardDeck();
    }

    public void initializationCardDeck() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                cardDeck.push(new Card(i, CardSuit.getSuit(j)));
            }
        }
        shuffleCard(cardDeck);
    }

    public void shuffleCard(Stack<Card> cardDeck) {
        Collections.shuffle(cardDeck);
    }

    public Card drawCard() {
        if (cardDeck.isEmpty()) {
            throwCardDeckToCardDeck();
            shuffleCard(cardDeck);
        }
        return cardDeck.pop();
    }

    public void throwCardDeckToCardDeck() {
        cardDeck.addAll(throwCardDeck);
        throwCardDeck.clear();

    }

    public boolean checkExceed(int score) {
        return score > 21;
    }

    public List<Player> finalWinner() {
        players.sort(finalScoreComparator);
        return players;
    }

    public List<Player> roundWinner() {
        List<Player> rankPlayer = new ArrayList<>(players);
        rankPlayer.sort(roundScoreComparator);
        rankPlayer.get(0).setFinalScoreOverlay(1);

        return rankPlayer;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
