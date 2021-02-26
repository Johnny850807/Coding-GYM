package enemy.skill.model;

import role.model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SummonerSpells extends Skill {
    private int mp = 50;
    private List<Enemy> enemyList = Arrays.asList(new Soldier(), new Guard(), new Mage());
    private SkillOfEnemy skillOfEnemy;

    public SummonerSpells() {
        skillOfEnemy = SkillOfEnemy.SUMMONER_SPELLS;
    }

    public SummonerSpells(int lostMp) {
        this.mp = lostMp;
        skillOfEnemy = SkillOfEnemy.SUMMONER_SPELLS;
    }

    @Override
    public boolean use(Round round) {
        System.out.println("使用" + skillOfEnemy.getName() + " " + skillOfEnemy.getDesc());
        Optional<Enemy> enemy = round.getEnemies().stream().filter(enemy1 -> enemy1.isTurnMe()).findAny();
        Boss boss = (Boss) enemy.get();
        if (boss.isMpUseAble(mp)) {
            boss.useMp(mp);
            Collections.shuffle(this.enemyList);
            Enemy summonEnemy = this.enemyList.get(0);
            System.out.println("成功召喚 " + summonEnemy.toString());
            round.addOthers(summonEnemy);
            return true;
        } else {
            System.out.println(" mp 不夠 " + boss.getMp());
            return false;
        }
    }
}
