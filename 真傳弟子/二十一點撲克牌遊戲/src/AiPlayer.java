public class AiPlayer extends Player {

    public AiPlayer(int number, BlackJack game) {
        super.setName("電腦" + number);
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
        int selcet = (int) (Math.random() * 2) + 1;

        switch (selcet) {
            case 1:
                return "y";
            case 2:
                return "n";
        }
        return null;
    }
}
