import card.Card;

import java.util.List;

public abstract class Player {
    String name;
    List<Card> handCards;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHandCards(List<Card> handCard) {
        this.handCards = handCard;
    }

    public List<Card> getHandCards() {
        return handCards;
    }
    public Card getHandCard(int index){
        return handCards.get(index);
    }

    public void removeHandCard(int index){
        handCards.remove(index);
    }

    public abstract Card playCard();
}
