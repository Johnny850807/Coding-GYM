package role.model;

import java.util.ArrayList;
import java.util.List;

public class RPGGame {

    private final List<Round> rounds = new ArrayList<>();
    private Player player = null;

    public static void main(String[] args) {
        RPGGame rpgGame = new RPGGame();
        rpgGame.init();
        for (Round round : rpgGame.getRounds()) {
            round.joinRound(rpgGame.player);
            while (round.nextRound()) {
                round.turnPlayerAttack();
                round.turnEnemyAttack();
            }
        }
    }

    private void createPlayer() {
        player = new Player();
        System.out.print("start game  ... join player=");
        player.showStatus();
    }

    public void init() {
        createPlayer();
        createRounds();
        System.out.println("=====================================");
    }

    private void createRounds() {
        Round round = new Round("第一關");
        round.addEnemy(new Soldier());
        round.addEnemy(new Soldier());
        round.addEnemy(new Soldier());
        round.addEnemy(new Soldier());
        round.addEnemy(new Guard());
        rounds.add(round);

        Round round2 = new Round("第二關");
        round2.addEnemy(new Soldier());
        round2.addEnemy(new Soldier());
        round2.addEnemy(new Mage());
        round2.addEnemy(new Mage());
        rounds.add(round2);

        Round round3 = new Round("第三關");
        round3.addEnemy(new Boss());
        rounds.add(round3);
        showAllRounds();
    }

    private void showAllRounds() {
        rounds.forEach(r -> {
            System.out.println(r.getName());
            r.getEnemies().forEach(enemy -> System.out.println(enemy.toString()));
        });
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
