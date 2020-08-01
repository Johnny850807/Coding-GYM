import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Hero hero = new Hero();
    private static Monster monster = new Monster();
    ;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("遊戲開始");
        System.out.println("請選擇武器(1)機關槍(2)散彈槍(3)狙擊槍");

        select();
        setMonsterHp();
        attackMonster();

    }

    private static void select() {
        int select;

        do {
            select = input.nextInt();

        } while (select < 1 || select > 3);

        switch (select) {
            case 1:
                hero.setGun(new MachineGun());
                System.out.println("您選擇的是機關槍");
                break;
            case 2:
                hero.setGun(new ExplosionGun());
                System.out.println("您選擇的是散彈槍");
                break;
            case 3:
                hero.setGun(new SniperGun());
                System.out.println("您選擇的是狙擊槍");
                break;
        }
    }

    public static void setMonsterHp() {
        int setHp;
        System.out.println("請輸入怪物血量");

        setHp = input.nextInt();
        monster.setHP(setHp);
    }

    public static void attackMonster() {
        int round = 0;

        for (int i = 1; monster.getHP() > 0; i++) {
            monster.setHP(monster.getHP() - hero.getGun().attack().getSumDamage());
            round++;
        }
        System.out.println("第" + round + "回合擊殺了怪物");
    }

}
