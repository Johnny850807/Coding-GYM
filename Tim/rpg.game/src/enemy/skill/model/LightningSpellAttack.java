package enemy.skill.model;

import role.model.Enemy;
import role.model.Player;
import role.model.Round;

import java.util.Optional;

public class LightningSpellAttack extends Skill {
    private int mp = 100;
    private int magicAttackValue = 250;
    SkillOfEnemy skillOfEnemy;

    public LightningSpellAttack() {
        skillOfEnemy = SkillOfEnemy.LIGHTNING_SPELL;
    }

    @Override
    public boolean use(Round round) {
        System.out.println("使用" + skillOfEnemy.getName() + " " + skillOfEnemy.getDesc());
        Player player = round.getPlayer();
        Optional<Enemy> optionalEnemy = round.getEnemies().stream().filter(e -> e.isTurnMe()).findAny();
        Enemy enemy = optionalEnemy.get();
        if (enemy.isMpUseAble(mp)) {
            enemy.useHp(magicAttackValue - player.getMdf());
            return true;
        } else {
            System.out.println(" mp 不夠 " + enemy.getMp());
            return true;
        }
    }
}
