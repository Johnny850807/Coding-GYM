package Poker21PointGameSystem;

import Player.Player;

import java.util.Comparator;

public class RankComparator implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        return (player1.getRank() > player2.getRank()) ? 1 : -1;
    }
}
