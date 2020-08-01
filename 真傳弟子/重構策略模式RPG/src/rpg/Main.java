package rpg;


import Skill.Skill;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static RpgSystem rpg = new RpgSystem();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        introductionHeroState();
        try {
            enterFight();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public static void introductionHeroState() {
        System.out.println("==========歡迎來到RPG回合制對戰==========");
        System.out.println("玩家擁有的技能有");
        rpg.setInitialHeroSkill();

        for (Skill skill : rpg.getHero().getSkills()) {
            System.out.println(skill.getName() + ": " + skill.getSkillDescribe());
        }
    }

    public static void enterFight() throws InterruptedException {

        for (int i = 1; i <= 3; i++) {
            Thread.sleep(2000);
            System.out.println("==========第" + i + "輪戰鬥==========");

            rpg.resetHeroState();
            System.out.println(rpg.getHero());
            rpg.createMonster();

            System.out.print("本回合的怪物有:");
            for (Role monster : rpg.getMonsters()) {
                System.out.print(monster.getName() + ",");
            }

            System.out.println();

            selectAttackMethod();
        }
        System.out.println("==========成功通關==========");

    }

    public static void selectAttackMethod() throws InterruptedException {
        int select;
        int selectSkillNumber;
        int selectMonster;

        while (true) {

            System.out.println("請玩家選擇攻擊方式:(1)普通攻擊(2)技能攻擊");
            do {
                select = input.nextInt();

            } while (select < 1 || select > 2);
            if (select == 1) {
                Thread.sleep(1000);
                selectMonster = getSelectMonster();
                int damage = rpg.normalAttack(rpg.getHero(), rpg.getMonsters().get(selectMonster));

                System.out.println("玩家使用了普通攻擊" + "造成了" + damage + "點傷害");

            } else {
                selectMonster = getSelectMonster();
                selectSkillNumber = selectSkillAndJudgementMp();

                Thread.sleep(1000);
                int damage = rpg.skillAttack(selectSkillNumber, rpg.getHero()
                        , rpg.getMonsters().get(selectMonster));

                System.out.println("玩家使用了" + rpg.getHero().getSkills().get(selectSkillNumber).getName()
                        + "造成了" + damage + "點傷害");
            }
            System.out.println(rpg.getHero());
            if (!leftMonster()) {
                System.out.println("==========輪到怪物攻擊==========");
                rpg.aiAttackMethod();
                if (!rpg.checkHeroAlive()) {
                    gameOver();
                }
                System.out.println(rpg.getHero());
            }
        }
    }

    private static int getSelectMonster() {
        System.out.println("請選擇要攻擊的目標");

        for (int i = 1; i <= rpg.getMonsters().size(); i++) {
            System.out.print("(" + i + ")" + rpg.getMonsters().get(i - 1).getName()
                    + ":" + rpg.getMonsters().get(i - 1).getHp() + "生命值");
        }
        return selectMonster();
    }

    private static int selectMonster() {
        int select;

        do {
            select = input.nextInt() - 1;
        } while (select < 0 || select > rpg.getMonsters().size() - 1);

        return select;
    }

    public static int selectSkillAndJudgementMp() {
        int selectSkillNumber;
        boolean mpNotEnough;

        System.out.println("請選擇使用的技能");
        for (int i = 1; i <= rpg.getHero().getSkills().size(); i++) {
            System.out.print("(" + i + ")" + rpg.getHero().getSkills().get(i - 1).getName());
        }
        do {
            selectSkillNumber = input.nextInt() - 1;
            mpNotEnough = rpg.checkHeroUseSkillMp(rpg.getHero().getSkills().get(selectSkillNumber).getConsumeMp(), rpg.getHero());

        } while (selectSkillNumber > rpg.getHero().getSkills().size() - 1 || !mpNotEnough);

        return selectSkillNumber;
    }

    public static boolean leftMonster() {
        rpg.checkMonsterAlive();

        for (Role monster : rpg.getDeadMonsters()) {
            System.out.println("[怪物]" + monster.getName() + "已倒下");
        }
        rpg.getDeadMonsters().clear();
        for (Role monster : rpg.getMonsters()) {
            System.out.println("[怪物]" + monster.getName() + "還剩下" + monster.getHp() + "血量");
        }

        if (rpg.getMonsters().isEmpty()) {
            System.out.println("全部怪物都倒下了，進到下一回合");
            return true;
        }
        return false;
    }

    public static void gameOver() {
        System.out.println("==========遊戲結束玩家死亡==========");
        System.exit(0);
    }
}

