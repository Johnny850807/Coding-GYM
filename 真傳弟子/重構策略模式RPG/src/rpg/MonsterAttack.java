package rpg;

import java.util.List;

public class MonsterAttack implements AiAttackLogic {
    RpgSystem rpg;
    List<Role> monsters;

    public MonsterAttack(RpgSystem rpg) {
        this.rpg = rpg;
        monsters = rpg.getMonsters();
    }

    @Override
    public void aiAttack() {
        try {
            for (Role monster : monsters) {
                int damage;
                int selectSkill = 0;
                int randomAttackMethod = (int) (Math.random() * 2);

                if (!monster.getSkills().isEmpty()) {
                    selectSkill = (int) (Math.random() * monster.getSkills().size());
                }

                if (monster.isAction()) {
                    if (randomAttackMethod == 0) {
                        damage = rpg.normalAttack(monster, rpg.getHero());
                    } else {
                        if (monster.getSkills().isEmpty()) {
                            damage = rpg.normalAttack(monster, rpg.getHero());
                        } else {
                            damage = rpg.skillAttack(selectSkill, monster, rpg.getHero());
                        }
                    }
                    System.out.println("[怪物]" + monster.getName() + "造了玩家" + damage + "的傷害");
                    Thread.sleep(1000);
                } else {
                    monster.setActionCount(monster.getActionCount() - 1);
                    if (monster.getActionCount() == 0) {
                        monster.setAction(true);
                        System.out.println("[怪物]" + monster.getName() + "已解凍");
                    }
                }

            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}