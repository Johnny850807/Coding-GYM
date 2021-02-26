package enemy.skill.model;

import role.model.Enemy;
import role.model.Player;

import java.util.List;

abstract public class EnemySkill extends Skill{

    protected SkillOfEnemy skillOfEnemy;

    public EnemySkill() {

    }

    public abstract boolean attack(Enemy enemy, Player player, List<Enemy> allEnemies);

}
