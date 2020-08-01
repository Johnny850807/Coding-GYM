public enum CardSuit {
    DIAMOND("方塊"),
    SPADE("黑桃"),
    CLUBS("梅花"),
    HEART("愛心");

    CardSuit(String suit) {
        this.suit = suit;
    }

    private String suit;

    public static CardSuit getSuit(int i) {

        switch (i) {
            case 1:
                return DIAMOND;
            case 2:
                return SPADE;
            case 3:
                return CLUBS;
            case 4:
                return HEART;
            default:
                return null;
        }

    }

    public String getSuit() {
        return suit;
    }
}
