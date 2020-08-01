package card;

public abstract class Card {
    String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract DuelResult duel(Card card);
}
