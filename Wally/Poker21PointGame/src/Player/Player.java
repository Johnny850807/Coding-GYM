package Player;

public abstract class Player {

    private int rank, cardPoint, score = 0;
    private static int playerAmount = 0;
    protected String name;

    public Player() {
        setRank(++playerAmount);
    }

    public abstract void setName(String name);

    public String getName() {
        return name;
    }

    public void setCardPoint(int cardPoint) {
        this.cardPoint = cardPoint;
    }

    public int getCardPoint() {
        return cardPoint;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

}
