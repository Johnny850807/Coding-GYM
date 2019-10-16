package Poker21PointGameSystem;

import Player.*;

import java.util.Comparator;

public class CardPointComparator implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        int compareResult = 0;
        if (player1.getCardPoint() < player2.getCardPoint()) {
            compareResult = 1;
        } else if (player1.getCardPoint() > player2.getCardPoint()) {
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
