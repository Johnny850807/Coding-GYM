package GamePlayer;

public class GuessOddNumberPasswordAI extends GuessPasswordAI {
    @Override
    public int guessPassword(int belowNumber, int topNumber) {
        int guessPasswordRange;
        if (topNumber - belowNumber > 2) {
            do {
                guessPasswordRange = (random.nextInt((topNumber - (belowNumber + 1))) + belowNumber + 1);
            } while (guessPasswordRange % 2 == 0);
            return guessPasswordRange;
        } else {
            return ++belowNumber;
        }
    }
}
