import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner input = new Scanner(System.in);

    public HumanPlayer(String name, BlackJack game) {
        super.setName(name);
        super.setGame(game);
    }

    @Override
    public Card play() {
        Card card = super.getGame().drawCard();
        super.setScoreOverlay(card.getRank());
        return card;
    }

    @Override
    public String select() {
        return input.next();
    }
}
