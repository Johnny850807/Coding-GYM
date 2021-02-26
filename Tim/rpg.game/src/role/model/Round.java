package role.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Round {
    private final String name;
    private List<Enemy> enemies = new CopyOnWriteArrayList();
    private List<Enemy> summonerSpellsEnemies = new ArrayList<>();
    private Player player;

    public void joinRound(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public String getName() {
        return name;
    }

    public Round(String name) {
        this.name = name;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }


    private void showStatus() {
        checkEnemyHp();
    }

    private void showPlayerStatus() {
        System.out.println("輪到玩家 " + this.player.toString());
    }

    public boolean nextRound() {
        showStatus();
        extraEffect();
        if (this.enemies.size() == 0) {
            System.out.println(this.name + "結束。");
            return false;
        }
        if (this.player.getHp() <= 0) {
            System.out.println(" 玩家被擊敗，遊戲結束。");
            return false;
        }
        return true;
    }

    private void extraEffect() {
        this.getPlayer().getExtraStatus().getSkillExtraDamages().forEach(h -> h.effect(this.getPlayer()));
        this.getEnemies().forEach(enemy -> enemy.getExtraStatus().getSkillExtraDamages().forEach(h -> h.effect(enemy)));
        this.getPlayer().checkEffects();
        this.getEnemies().forEach(Role::checkEffects);
    }

    private void checkEnemyHp() {
        Optional<Enemy> optionalEnemy = enemies.stream().filter(r -> !r.isExist()).findAny();
        optionalEnemy.ifPresent(enemy -> System.out.println(enemy.getName() + " 被擊敗。"));
        enemies = enemies.stream().filter(Role::isExist).collect(Collectors.toList());
    }


    private Optional<SkillExtraDamage> isNext(Role role) {
        return role.getExtraStatus().getSkillExtraDamages().stream().filter(SkillExtraDamage::isAble).findAny();
    }

    public void turnEnemyAttack() {
        System.out.println("輪到 敵人! ");
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (!isNext(enemy).isPresent()) {
                System.out.println(" 換 " + enemy.getName() + " 攻擊");
                enemy.setTurnMe(true);
                enemy.action(this);
                enemy.setTurnMe(false);
                checkEnemyHp(enemy);
            } else {
                System.out.println(" turn " + enemy.getName() + " over this round");
            }
            enemies.addAll(summonerSpellsEnemies);
            summonerSpellsEnemies.clear();
        }
    }

    private void checkEnemyHp(Enemy enemy) {
        if (enemy.getHp() <= 0) {
            System.out.println(enemy.getName() + " 被擊敗。");
        }
    }


    public void turnPlayerAttack() {
        showEnemies();
        showPlayerStatus();
        player.setTurnMe(true);
        player.action(this);
        player.setTurnMe(false);
        checkEnemyHp();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void showEnemies() {
        System.out.println("請選擇攻擊對象:");
        for (int i = 0; i < getEnemies().size(); i++) {
            Enemy enemy = getEnemies().get(i);
            System.out.print(i + ") " + enemy.getName()+" ");
        }
        System.out.println("");
    }

    public Enemy findIndexByEnemey() {
        Enemy attackEnemy;
        showEnemies();
        do {
            Scanner scanner = new Scanner(System.in);
            int attackIndex = scanner.nextInt();
            attackEnemy = getEnemies().get(attackIndex);
        } while (attackEnemy == null);

        System.out.println(attackEnemy);
        return attackEnemy;
    }

    public void areaOfEffect(int abilityPower) {
        getEnemies().forEach(enemy -> {
            enemy.minsMdf(enemy.getMdf());
            enemy.useHp(abilityPower - enemy.getMdf());
        });
    }

    public void addOthers(Enemy summonEnemy) {
        this.summonerSpellsEnemies.add(summonEnemy);
    }

}
