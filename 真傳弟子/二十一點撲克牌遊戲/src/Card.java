public class Card {
    private int rank;
    private CardSuit suit;

    public Card(int rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public String getRankEnglish(){
        switch (rank){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(rank);
        }
    }
    @Override
    public String toString() {
        return "翻開了 .... " + suit.getSuit() + getRankEnglish();
    }
}
