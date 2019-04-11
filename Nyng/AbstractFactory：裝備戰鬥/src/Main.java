import Game.WeaponFactory;
import Sprite.Role;

import static Utility.Asker.*;

public class Main {

    private static final int PHYSICAL = 1;
    private static final int MAGICAL = 2;

    public static void main(String[] args) {

        // Game logic
        boolean reply = true;
        Role role;
        Role opponent;

        /**
         * Game loop
         */
        while (reply) {

            /**
             * Select Role and Opponent
             */
            role = selectRole();
            opponent = selectOpponent();


            /**
             * Start Fight
             */
            role.showStatus();
            opponent.showStatus();
            do {

                switch (selectRoleAction(role)) {
                    case PHYSICAL:
                        role.physicalAttack(opponent);
                        break;
                    case MAGICAL:
                        role.magicalAttack(opponent);
                        break;
                    default:
                }

                if (!opponent.isDead()) {
                    switch (selectOpponentAction(opponent)) {
                        case PHYSICAL:
                            opponent.physicalAttack(role);
                            break;
                        case MAGICAL:
                            opponent.magicalAttack(role);
                            break;
                        default:
                    }
                }

                role.showStatus();
                opponent.showStatus();

            } while (!role.isDead() && !opponent.isDead());
            if (role.isDead()) {
                System.out.format("%s wins%n", opponent.getName());
            } else {
                System.out.format("%s wins%n", role.getName());
            }


            /**
             * Play again?
             */
            reply = askPlayAgain();
        }


    }

}
