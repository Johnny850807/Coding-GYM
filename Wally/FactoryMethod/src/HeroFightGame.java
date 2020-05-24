import java.util.Random;
import java.util.Scanner;

public class HeroFightGame {

    public static void main(String[] args) {
        System.out.println("Game Start");
        HeroFightGame heroFightGame = new HeroFightGame();
        heroFightGame.setUpMonsters();
        heroFightGame.setUpHero();
        heroFightGame.gameStart();
    }

    private Character[] monsters;

    private void setUpMonsters() {
        System.out.println("Monster is setting");
        Random random = new Random();
        monsters = new Character[3];
        for (int index = 0; index < monsters.length; index++) {
            Character monster = monsters[index] = new Monster();
            monster.setHp((random.nextInt(2) + 1) * 2000);
        }
    }

    private Hero hero;

    private void setUpHero() {
        System.out.println("Hero is setting");
        hero = new Hero();
        hero.setHp(500);
    }

    private int round = 0;

    private void gameStart() {
        int monsterAmount = monsters.length;
        System.out.println("Monster amount is " + monsterAmount);
        for (int index = 0; index < monsterAmount; index++) {
            System.out.println("Find " + (index + 1) + " monster");
            Character monster = monsters[index];
            heroAttackMonster(monster);
        }
        gameOver();
    }

    private void heroAttackMonster(Character monster) {
        do {
            round++;
            System.out.println("Round " + round + " fight !!!");
            GunType gunType = heroSelectGun();
            System.out.println("Hero selected " + gunType);
            int heroAttackDamage = hero.attack(gunType.getGun());
            System.out.println("Hero has attacked the monster " + heroAttackDamage + " damage");
            monster.setHp(monster.getHp() - heroAttackDamage);
            System.out.println("Monster only has " + Math.max(0, monster.getHp()) + " hp");
        } while (monster.getHp() > 0);
    }

    private Scanner scanner = new Scanner(System.in);

    private GunType heroSelectGun() {
        int gunSelect;
        do {
            System.out.println("英雄選擇槍枝: 1. 機關槍 2. 散彈槍 3. 狙擊槍");
            gunSelect = scanner.nextInt();
        } while (gunSelect < 1 || gunSelect > 4);
        return GunType.values()[gunSelect - 1];
    }

    private void gameOver() {
        System.out.println("遊戲結束");
        System.out.println("第 " + round + " 回合結束");
    }
}
