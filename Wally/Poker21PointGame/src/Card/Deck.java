package Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deck {
    List<Card> deck = new ArrayList<>(52);
    Set<Card> discard = new HashSet<>(52);

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        Set<Card> deck = new HashSet<>(52);
        for (Suit suit : Suit.values()) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(suit, rank));
            }
        }
        this.deck.addAll(deck);
    }

    public Card dealCard() {
        int cardIndex = (deck.size() - 1);
        Card card = deck.get(cardIndex);
        deck.remove(cardIndex);
        discard.add(card);
        return card;
    }

    public void suffle() {
        deck.addAll(discard);
    }
}
