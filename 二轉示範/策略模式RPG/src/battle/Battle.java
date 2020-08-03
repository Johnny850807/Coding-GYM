package battle;

import role.HumanHero;
import role.Enemy;
import role.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static utils.Delay.delay;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Battle {
    private Role humanHero;
    private List<Role> enemies;
    private List<Role> allRoles;
    private boolean gameOver = false;
    private Role currentTurnRole;

    public Battle(HumanHero humanHero, Enemy... enemies) {
        this.humanHero = humanHero;
        this.enemies = new ArrayList<>(Arrays.asList(enemies));
        setupAllRoles(humanHero);
    }

    private void setupAllRoles(HumanHero humanHero) {
        allRoles = new ArrayList<>();
        allRoles.add(humanHero);
        allRoles.addAll(this.enemies);
        for (Role role : allRoles) {
            role.setBattle(this);
        }
    }

    public void startBattle() {
        printEnemies();
        System.out.println("戰鬥開始！");

        int turn = 0;
        while (!gameOver) {
            delay(800);
            currentTurnRole = allRoles.get(turn);
            System.out.printf("\n輪到 %s 了！ (%s) \n", currentTurnRole.getName(), currentTurnRole.getCapability());
            currentTurnRole.move();
            checkDeadRoles();
            checkBattleOver();
            turn = (turn + 1) % allRoles.size();
        }

        humanHero.restoreCapability();
    }

    private void printEnemies() {
        System.out.println(enemies.stream().map(Role::getName)
                .collect(Collectors.joining(" ")));
    }

    private void checkDeadRoles() {
        List<Role> deadRoles = allRoles.stream()
                .filter(Role::isDead)
                .collect(Collectors.toList());
        deadRoles.forEach(r -> System.out.printf("%s 死亡。\n", r.getName()));
        deadRoles.forEach(this::removeRole);
    }

    private void removeRole(Role r) {
        enemies.remove(r);
        allRoles.remove(r);
    }

    private void checkBattleOver() {
        if (humanHero.isDead()) {
            gameOver = true;
            System.out.println("遊戲結束！失敗告終！");
        } else if (enemies.stream().allMatch(Role::isDead)) {
            gameOver = true;
            System.out.println("你贏了這輪戰鬥！");
        }
    }

    public void addAlly(Role allyRole) {
        getAllies().add(allyRole);
        allRoles.add(allyRole);
        allyRole.setBattle(this);
    }

    public List<Role> getAllies() {
        if (currentTurnRole == humanHero) {
            return Collections.singletonList(humanHero);
        } else {
            return enemies;
        }
    }

    public List<Role> getOpponents() {
        if (currentTurnRole == humanHero) {
            return enemies;
        } else {
            return Collections.singletonList(humanHero);
        }
    }
}
