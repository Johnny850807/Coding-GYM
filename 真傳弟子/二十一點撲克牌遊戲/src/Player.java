public abstract class Player {
    private String name;
    private int score;
    private int finalScore;
    private BlackJack game;

    public abstract Card play();

    public abstract String select();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(BlackJack game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScoreOverlay(int score) {
        this.score += score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScoreOverlay(int finalScore) {
        this.finalScore += finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public BlackJack getGame() {
        return game;
    }

}
