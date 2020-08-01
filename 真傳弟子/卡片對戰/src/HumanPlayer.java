import 卡片對戰.card.Card;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner input = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard() {
        int select;
        Card selectCard;

        System.out.println("請選擇要出的牌");
        for (int i = 1; i <= getHandCards().size(); i++) {
            System.out.print(" (" + i + ") " + getHandCards().get(i - 1));
        }
        do {
            select = input.nextInt();
        } while (select < 1 || select > 3);

        selectCard = getHandCard(select - 1);
        removeHandCard(select - 1);
        System.out.println(getName() + " 出的是 " + selectCard);

        return selectCard;
    }
}
