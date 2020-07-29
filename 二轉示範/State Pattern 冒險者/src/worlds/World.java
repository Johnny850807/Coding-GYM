package worlds;

import worlds.sprites.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class World {
    private final static int WIDTH = 10;
    private final static int HEIGHT = 10;
    private Player player;
    private Sprite[][] map = new Sprite[HEIGHT][WIDTH];

    // since sprites could be removed from in every other's turn during turn iteration
    // CopyOnWriteArrayList is necessary to avoid ConcurrentModificationException
    private List<Sprite> sprites = new CopyOnWriteArrayList<>();
    private boolean gameOver = false;

    public void setPlayer(Player player) {
        this.player = player;
        addSprite(player);
    }

    public Player getPlayer() {
        return player;
    }

    public void addSprite(Sprite sprite) {
        int x = sprite.getX(), y = sprite.getY();
        if (map[y][x] != null) {
            throw new IllegalArgumentException(String.format("(%d, %d) has been added a sprite.", x, y));
        }
        sprite.setWorld(this);
        map[y][x] = sprite;
        sprites.add(sprite);
    }

    public void removeSprite(Sprite sprite) {
        if (sprite == player) {
            gameOver = true;
        }
        sprites.remove(sprite);
        map[sprite.getY()][sprite.getX()] = null;
        sprite.setWorld(null);
    }

    public void start() {
        int round = 0;
        while (!gameOver) {
            round++;
            randomlyGenerateMonstersAndTreasures();
            for (Sprite sprite : sprites) {
                if (sprite.canMove()) {
                    printMap();
                    sprite.onTurnBegins();
                    sprite.onTurnEnds();
                }
            }
        }

        System.out.println("遊戲結束！總共生存了" + round + "回合！");
    }

    private void randomlyGenerateMonstersAndTreasures() {
        Random random = new Random();
        if (random.nextInt(100) <= 60) {  // 60%
            int treasureCount = random.nextInt(2) + 1;
            int monsterCount = treasureCount == 2 ? 0 : random.nextInt(2);
            if (treasureCount > 0 || monsterCount > 0) {
                List<Point> availablePoints = getAvailablePoints();
                Collections.shuffle(availablePoints);
                int pointIndex = 0;
                for (int i = 0; i < treasureCount; i++) {
                    System.out.println("新寶藏生成...");
                    Point p = availablePoints.get(pointIndex++);
                    addSprite(new Treasure(p.x, p.y));
                }
                for (int i = 0; i < monsterCount; i++) {
                    System.out.println("新怪物生成...");
                    Point p = availablePoints.get(pointIndex++);
                    addSprite(new Monster(p.x, p.y));
                }
            }
        }
    }

    public void printMap() {
        printLine();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (map[i][j] == null) {
                    System.out.print(' ');
                } else {
                    System.out.print(map[i][j].getSymbol());
                }
            }
            System.out.println();
        }
        printLine();
    }

    private void printLine() {
        for (int i = 0; i < WIDTH; i++) {
            System.out.print('=');
        }
        System.out.println();
    }

    public void moveSpriteForward(Sprite sprite) {
        int oldX = sprite.getX(), oldY = sprite.getY();
        int newX = sprite.getX(), newY = sprite.getY();
        switch (sprite.getDirection()) {
            case DOWN:
                newY = newY == HEIGHT - 1 ? newY : newY + 1;
                break;
            case LEFT:
                newX = newX == 0 ? newX : newX - 1;
                break;
            case RIGHT:
                newX = newX == WIDTH - 1 ? newX : newX + 1;
                break;
            case UP:
                newY = newY == 0 ? newX : newY - 1;
                break;
        }
        handleNewPositionAfterMovement(sprite, oldX, oldY, newX, newY);
    }

    private void handleNewPositionAfterMovement(Sprite sprite, int oldX, int oldY, int newX, int newY) {
        Sprite collidedSprite = map[newY][newX];
        if (collidedSprite != null) {
            collidedSprite.onCollisionWith(sprite);
            sprite.onCollisionWith(collidedSprite);
        } else {
            map[oldY][oldX] = null;
            map[newY][newX] = sprite;
            sprite.setY(newY);
            sprite.setX(newX);
        }
    }

    public List<Point> getAvailablePoints() {
        List<Point> points = new ArrayList<>();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (map[y][x] == null) {
                    points.add(new Point(x, y));
                }
            }
        }
        return points;
    }

    public Optional<Sprite> getSpriteInFrontOf(Sprite sprite) {
        return sprites.stream()
                .filter(s -> !(s instanceof Barrier) && s != sprite)
                .filter(s -> isFacingWithoutBarriersInBetween(sprite, s, WIDTH))
                .findFirst();
    }

    public List<Sprite> getAllSpritesInFrontOf(Sprite sprite) {
        return sprites.stream()
                .filter(s -> !(s instanceof Barrier) && s != sprite)
                .filter(s -> isFacingWithoutBarriersInBetween(sprite, s, WIDTH))
                .collect(Collectors.toList());
    }

    public Collection<Direction> getAvailableDirections(Sprite sprite) {
        HashSet<Direction> availableDirections = new HashSet<>();

        int x = sprite.getX(), y = sprite.getY();
        if (x - 1 >= 0 && map[y][x - 1] == null) {
            availableDirections.add(Direction.LEFT);
        }
        if (x + 1 < WIDTH && map[y][x + 1] == null) {
            availableDirections.add(Direction.RIGHT);
        }
        if (y - 1 >= 0 && map[y - 1][x] == null) {
            availableDirections.add(Direction.UP);
        }
        if (y + 1 < HEIGHT && map[y + 1][x] == null) {
            availableDirections.add(Direction.DOWN);
        }
        return availableDirections;
    }

    public boolean isFacingWithoutBarriersInBetween(Sprite from, Sprite to, int distance) {
        if (getDistance(from, to) > distance) {
            return false;
        }

        switch (from.getDirection()) {
            case UP:
                return from.getX() == to.getX() && from.getY() > to.getY()
                        && countBarriersInBetween(from, to) == 0;
            case DOWN:
                return from.getX() == to.getX() && from.getY() < to.getY()
                        && countBarriersInBetween(from, to) == 0;
            case LEFT:
                return from.getY() == to.getY() && from.getX() > to.getX()
                        && countBarriersInBetween(from, to) == 0;
            case RIGHT:
                return from.getY() == to.getY() && from.getX() < to.getX()
                        && countBarriersInBetween(from, to) == 0;
            default:
                throw new Error("Impossible");
        }
    }

    public int countBarriersInBetween(Sprite from, Sprite to) {
        int count = 0;
        int smallX = Math.min(from.getX(), to.getX()), bigX = Math.max(from.getX(), to.getX());
        int smallY = Math.min(from.getY(), to.getY()), bigY = Math.max(from.getY(), to.getY());

        for (int x = smallX; x <= bigX; x++) {
            for (int y = smallY; y <= bigY; y++) {
                if (map[y][x] != null && map[y][x] instanceof Barrier) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Sprite> getAllSprites() {
        return sprites;
    }

    public int getDistance(Sprite from, Sprite to) {
        return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
    }


    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void teleport(Sprite sprite, int x, int y) {
        map[sprite.getY()][sprite.getX()] = null;
        sprite.setX(x);
        sprite.setY(y);
        map[y][x] = sprite;
    }
}
