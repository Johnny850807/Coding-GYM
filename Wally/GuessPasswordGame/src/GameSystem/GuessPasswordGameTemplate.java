package GameSystem;

import java.util.Scanner;

public abstract class GuessPasswordGameTemplate {

    protected final Scanner scanner = new Scanner(System.in);

    protected void gameProcess() {
        start();
        playOneSession();
        end();
    }

    protected abstract void start();

    protected void playOneSession() {
        int currentRound = 0;
        do {
            playOneRound(++currentRound);
        } while (!isGameOver());
    }

    protected abstract void playOneRound(int currentRound);

    protected abstract boolean isGameOver();

    protected abstract void end();
}
