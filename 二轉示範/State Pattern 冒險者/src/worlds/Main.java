package worlds;

import worlds.sprites.Barrier;
import worlds.sprites.Monster;
import worlds.sprites.Player;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.setPlayer(new Player(0, 1));

        int alternate = 0;
        for (int y = 0; y < world.getHeight(); y+= 2) {
            int start = alternate++ % 2;
            for (int x = start; x < world.getWidth(); x+= 2) {
                world.addSprite(new Barrier(x, y));
            }
        }

        world.addSprite(new Monster(7, 3));
        world.addSprite(new Monster(1, 4));
        world.addSprite(new Monster(2, 9));

        world.start();
    }
}
