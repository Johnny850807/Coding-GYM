package Utility;

import Game.*;
import Sprite.Role;

import java.util.Random;
import java.util.Scanner;

public class Asker {

    private static final char NINJA = '1';
    private static final char WARRIOR = '2';
    private static final char BOXER = '3';
    private static final char EASY = '1';
    private static final char HARD = '2';
    private static Random rand = new Random();


    public static Scanner reader = new Scanner(System.in);

    public static boolean askPlayAgain() {
        System.out.println("Play Again? (Y/N)");
        switch (reader.next().charAt(0)) {
            case 'Y':
            case 'y':
                return true;
            default:
                return false;
        }
    }

    public static Role selectRole() {
        System.out.print("Choose a name: ");
        String name = reader.next();
        System.out.println("Select Role: (1) Ninja (2) Warrior (3) Boxer.");
        Role role;
        switch (reader.next().charAt(0)) {
            case NINJA:
                role = new Role(777, 3000, new NinjaWeaponFactory());
                break;
            case WARRIOR:
                role = new Role(77777, 1000, new WarriorWeaponFactory());
                break;
            case BOXER:
                role = new Role(7777, 1000, new BoxerWeaponFactory());
                break;
            default:
                role = new Role(77777, 3000, new NinjaWeaponFactory());
        }
        role.setName(name);
        return role;
    }

    public static Role selectOpponent() {

        System.out.print("Select Difficulty: (1) Easy (2) Hard.: ");
        Role opponent;
        switch (reader.next().charAt(0)) {
            case EASY:
                opponent = new Role(4000, 4000, new EasyOpponentWeaponFactory());
                opponent.setName("Boss(Easy)");
                break;
            case HARD:
                opponent = new Role(10000, 10000, new HardOpponentWeaponFactory());
                opponent.setName("Boss(Hard)");
                break;
            default:
                opponent = new Role(99999, 99999, new HardOpponentWeaponFactory());
                opponent.setName("Boss(???)");
        }
        return opponent;
    }

    public static int selectRoleAction(Role role) {
        System.out.format("Select %s's Action: (1) %s (2) %s: ",
                role.getName(),
                role.getAttackWeapon().getName(),
                role.getMagicPower().getName());

        return reader.next().charAt(0) - '0';
    }

    public static int selectOpponentAction(Role opponent) {
        return rand.nextInt(2) + 1;
    }

}