package worlds.sprites;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Player extends AbstractSprite {
    private final static Map<Direction, Character> directionKeyMap = new HashMap<>();

    static {
        directionKeyMap.put(Direction.UP, 'w');
        directionKeyMap.put(Direction.DOWN, 's');
        directionKeyMap.put(Direction.LEFT, 'a');
        directionKeyMap.put(Direction.RIGHT, 'd');
    }

    private Scanner in = new Scanner(System.in);


    public Player(int x, int y) {
        super(x, y, 500, "玩家");
    }

    @Override
    public void decideAction() {
        int choice = inputNumber(1, 2, "請選擇 (1) 移動 (2) 攻擊：");
        if (choice == 1) {
            onMoveForwardDecisionMade();
        } else {
            onAttackDecisionMade();
        }
    }

    @Override
    public void collide(Sprite sprite) {
    }

    @Override
    public Direction decideDirection(Direction... directions) {
        String message = generateDirectionChoicesMessage(directions);
        char choice = inputCharAsLowercase(directionKeyMap.values(), message);
        return getDirectionFromKeyChar(choice);
    }

    private Direction getDirectionFromKeyChar(char choice) {
        for (Map.Entry<Direction, Character> entry : directionKeyMap.entrySet()) {
            if (entry.getValue() == choice) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("Bug.");
    }

    private String generateDirectionChoicesMessage(Direction[] directions) {
        return "請選擇方位 " + Arrays.stream(directions)
                .map(d -> String.format("(%s) %s", directionKeyMap.get(d), d))
                .collect(Collectors.joining(" "));
    }

    @Override
    public void performAttack() {
        getWorld().getAllSpritesInFrontOf(this)
                .forEach(s -> s.onBeingAttackedBy(this, Integer.MAX_VALUE /*infinity*/));
    }

    private int inputNumber(int validStart, int validEnd, String message) {
        System.out.println(message);
        try {
            int num = in.nextInt();
            if (num >= validStart && num <= validEnd) {
                return num;
            } else {
                System.err.printf("只能輸入範圍 %d ~ %d 的數字。\n", validStart, validEnd);
                return inputNumber(validStart, validEnd, message);
            }
        } catch (InputMismatchException err) {
            in.nextLine();  // consume the invalid characters
            System.err.println("請輸入數字！");
            return inputNumber(validStart, validEnd, message);
        }
    }

    private char inputCharAsLowercase(final Collection<Character> availableChars, String message) {
        System.out.println(message);
        String next = in.next().trim().toLowerCase();
        if (next.length() != 1) {
            System.out.println("請只輸入一個字元！");
            return inputCharAsLowercase(availableChars, message);
        }
        char c = next.charAt(0);
        if (!availableChars.contains(c)) {
            System.out.println("此字元不合法！");
            return inputCharAsLowercase(availableChars, message);
        }
        return c;
    }

    @Override
    public char getSymbol() {
        return getDirection() == Direction.UP ? '↑' :
                getDirection() == Direction.DOWN ? '↓' :
                        getDirection() == Direction.LEFT ? '←' : '→';
    }
}
