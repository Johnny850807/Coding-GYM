package rpg;

import HeroSkill.*;
import Monster.Boss;
import Monster.Monster;
import Monster.Soldier;
import Monster.Witch;
import Monster.Guard;
import rpg.RpgSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static RpgSystem rpg = new RpgSystem();
    private static HeroSkill[] heroSkill;
    private static List<Monster> monsters = rpg.getMonsters();
    private static List<Monster> deadMonsters;
    private static int count;
    private static int soliderAmount;
    private static int witchAmount;
    private static int guardAmount;
    private static int bossAmount;


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
        rpg.getHero().setSkills(new HeroSkill[]{new FireBall(rpg), new Freeze(rpg), new StrengthenBody(rpg), new WaterBall(rpg)});
        heroSkill = rpg.getHero().getSkills();

        System.out.println("==========歡迎來到RPG回合制對戰==========");
        System.out.println("玩家擁有的技能有");
        for (HeroSkill skill : heroSkill) {
            System.out.println(skill.getName() + ": " + skill.getSkillDescribe());
        }
    }

    public static void enterFight() throws InterruptedException {

        for (int i = 1; i <= 3; i++) {
            Thread.sleep(2000);
            System.out.println("==========第" + i + "輪戰鬥==========");

            rpg.resetHeroState();
            System.out.println(rpg.getHero());
            createMonster();

            selectAttackMethod();
            roundAdjustmentMonsterAmount();
        }
    }

    private static void createMonster() {
        roundAdjustmentMonsterAmount();

        for (int j = 0; j < soliderAmount; j++) {
            rpg.getMonsters().add(new Soldier());
        }
        for (int j = 0; j < guardAmount; j++) {
            rpg.getMonsters().add(new Guard());
        }
        for (int j = 0; j < witchAmount; j++) {
            rpg.getMonsters().add(new Witch(rpg));
        }
        for (int j = 0; j < bossAmount; j++) {
            rpg.getMonsters().add(new Boss(rpg));
        }
        System.out.print("本回合的怪物有:");
        for (Monster monster : monsters) {
            System.out.print(monster.getName() + ",");
        }
        System.out.println();

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

                System.out.println("玩家使用了普通攻擊" + "造成了" + rpg.heroNormalAttack(rpg.getHero(), monsters.get(selectMonster)) + "點傷害");
                System.out.println(rpg.getHero());

                if (judgementLeftMonster()) return;
            } else {
                selectMonster = getSelectMonster();

                selectSkillNumber = selectSkillAndJudgementMp();

                Thread.sleep(1000);
                int damage = rpg.heroSkillAttack(selectSkillNumber, rpg.getHero(), monsters.get(selectMonster));
                System.out.println("玩家使用了" + rpg.getHero().getSkills()[selectSkillNumber].getName() + "造成了" + damage + "點傷害");

                System.out.println(rpg.getHero());
                if (judgementLeftMonster()) return;
            }
            System.out.println("==========輪到怪物攻擊==========");
            turnAiAttack();
            System.out.println(rpg.getHero());
        }
    }

    private static void turnAiAttack() throws InterruptedException {

        for (int i = 0; i < monsters.size(); i++) {
            int damage;
            int randomAttackMethod = (int) (Math.random() * 2);

            if (monsters.get(i).isAction()) {
                if (randomAttackMethod == 0) {
                    damage = rpg.monsterNormalAttack(monsters.get(i), rpg.getHero());
                } else {
                    if (monsters.get(i).getSkill() == null) {
                        damage = rpg.monsterNormalAttack(monsters.get(i), rpg.getHero());
                    } else {
                        damage = rpg.monsterSkillAttack(monsters.get(i), rpg.getHero());
                    }
                }
                System.out.println("[怪物]" + monsters.get(i).getName() + "造了玩家" + damage + "的傷害");
                Thread.sleep(1000);
            } else {
                monsters.get(i).setActionCount(monsters.get(i).getActionCount() - 1);
                if (monsters.get(i).getActionCount() == 0) {
                    monsters.get(i).setAction(true);
                }
            }

            if (!rpg.checkHeroAlive()) {
                gameOver();
            }
        }
    }

    private static int getSelectMonster() {
        int selectMonster;
        System.out.println("請選擇要攻擊的目標");

        for (int i = 1; i <= monsters.size(); i++) {
            System.out.print("(" + i + ")" + monsters.get(i - 1).getName() + ":" + monsters.get(i - 1).getHp() + "生命值");
        }
        selectMonster = selectMonster();
        return selectMonster;
    }

    private static int selectMonster() {
        int select;
        do {
            select = input.nextInt() - 1;
        } while (select < 0 || select > monsters.size() - 1);

        return select;
    }

    private static boolean judgementLeftMonster() {
        deadMonsters = rpg.checkMonsterAlive();

        for (Monster monster : deadMonsters) {
            System.out.println("[怪物]" + monster.getName() + "已倒下");
        }
        deadMonsters.clear();
        for (Monster monster : monsters) {
            System.out.println("[怪物]" + monster.getName() + "還剩下" + monster.getHp() + "血量");
        }

        if (monsters.isEmpty()) {
            System.out.println("全部怪物都倒下了，進到下一回合");
            return true;
        }
        return false;
    }

    public static int selectSkillAndJudgementMp() {
        int selectSkillNumber;
        boolean mpNotEnough;

        System.out.println("請選擇使用的技能");
        for (int i = 1; i <= heroSkill.length; i++) {
            System.out.print("(" + i + ")" + heroSkill[i - 1].getName());
        }
        do {
            selectSkillNumber = input.nextInt() - 1;
            mpNotEnough = (rpg.checkHeroUseSkillMp(heroSkill[selectSkillNumber].getConsumeMp(), rpg.getHero()));

            if (!mpNotEnough) {
                System.out.println("魔力不足請重新選擇");
            }

        } while (selectSkillNumber > heroSkill.length - 1 || !mpNotEnough);

        return selectSkillNumber;
    }

    private static void roundAdjustmentMonsterAmount() {
        count++;
        switch (count) {
            case 1:
                soliderAmount = 4;
                guardAmount = 1;
                witchAmount = 0;
                bossAmount = 0;
                break;
            case 2:
                soliderAmount = 2;
                guardAmount = 0;
                witchAmount = 2;
                bossAmount = 0;
                break;
            case 3:
                soliderAmount = 0;
                guardAmount = 0;
                witchAmount = 0;
                bossAmount = 1;
                break;
        }
    }

    public static void gameOver() {
        System.out.println("==========遊戲結束玩家死亡==========");
        System.exit(0);
    }

}
