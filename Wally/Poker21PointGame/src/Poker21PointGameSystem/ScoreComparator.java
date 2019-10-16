package Poker21PointGameSystem;

import Player.Player;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        int compareResult = 0;
        if (player1.getScore() < player2.getScore()) {
            compareResult = 1;
        } else if (player1.getScore() > player2.getScore()) {
            compareResult = -1;
        } else {
            if (player1.getRank() > player2.getRank()) {
                compareResult = 1;
            } else if (player1.getRank() < player2.getRank()) {
                compareResult = -1;
            }
        }
        return compareResult;
    }
}
