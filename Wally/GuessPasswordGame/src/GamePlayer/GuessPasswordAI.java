package GamePlayer;

import java.util.Random;

public class GuessPasswordAI extends Player {

    protected static final Random random = new Random();

    @Override
    public void setName() {
        for (int nameIndex = 0; nameIndex < (random.nextInt(3) + 3); nameIndex++) {
            name += (char) (random.nextInt(26) + 65);
        }
    }

    @Override
    public int guessPassword(int belowNumber, int topNumber) {
        return (random.nextInt((topNumber - (belowNumber + 1))) + belowNumber + 1);
    }
}
