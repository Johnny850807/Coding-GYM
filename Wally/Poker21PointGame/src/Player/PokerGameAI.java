package Player;

import java.util.Random;

public class PokerGameAI extends Player {

    @Override
    public void setName(String name) {
        Random random = new Random();
        for (int nameIndex = 0; nameIndex < (random.nextInt(3) + 3); nameIndex++) {
            name += (char) (random.nextInt(26) + 65);
        }
        this.name = name;
    }
}
