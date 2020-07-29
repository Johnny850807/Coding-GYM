package worlds.sprites;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public enum Direction {
    UP("上"), DOWN("下"), LEFT("左"), RIGHT("右");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
