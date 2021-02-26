package role.model;

import enemy.skill.model.NormalAttack;
import enemy.skill.model.SummonerSpells;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Enemy {
    private final List<Enemy> summonerEnemies = new ArrayList<>();

    public Boss() {
        super("BOSS", 1000, 300, 90, 40, 40);
        skill = new SummonerSpells();
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }

    @Override
    public void action(Round round) {
        if (!skill.use(round)) {
            setSkill(new NormalAttack());
            skill.use(round);
        } else {
            round.getEnemies().addAll(this.summonerEnemies);
            this.summonerEnemies.clear();
        }
    }
}
