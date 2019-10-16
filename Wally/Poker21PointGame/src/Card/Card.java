package Card;

public class Card {
    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        setSuit(suit);
        setRank(rank);
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String card = suit.name();
        switch (rank) {
            case 11:
                card += "J";
                break;
            case 12:
                card += "Q";
                break;
            case 13:
                card += "K";
                break;
            default:
                card += String.valueOf(rank);
                break;
        }
        return card;
    }
}
