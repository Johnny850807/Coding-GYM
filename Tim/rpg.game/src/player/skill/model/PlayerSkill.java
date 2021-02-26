package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Enemy;
import role.model.Player;
import role.model.Round;

import java.util.List;
import java.util.Scanner;

abstract public class PlayerSkill extends Skill {

    public PlayerSkill() {
        //super(mp, physicalInjureValue, magicInjureValue);
    }

    public abstract  boolean use(Round round);

    protected Enemy getEnemy(Player player, List<Enemy> enemies) {
        System.out.println("使用 普通攻擊(" + player.getAp() + ") 請選擇攻擊目標:");
        for (int i = 0; i < enemies.size(); i++) {
            Enemy h = enemies.get(i);
            System.out.println(i + ") " + h.toString());
        }
        Scanner scanner = new Scanner(System.in);
        int attackIndex = scanner.nextInt();
        Enemy enemy = enemies.get(attackIndex);
        return enemy;
    }

}
