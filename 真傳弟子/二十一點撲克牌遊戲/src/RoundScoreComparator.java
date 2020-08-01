import java.util.Comparator;

public class RoundScoreComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o2.getScore() - o1.getScore();
    }
}
