package GamePlayer;

import java.util.Scanner;

public abstract class Player {

    protected final Scanner scanner = new Scanner(System.in);
    protected String name = "";

    public Player() {
        setName();
    }

    public abstract void setName();

    public String getName() {
        return name;
    }

    public abstract int guessPassword(int belowNumber, int topNumber);
}
