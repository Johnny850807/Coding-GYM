import card.Card;

public class AiPlayer extends Player {
    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard() {
        int randomSelect = (int) (Math.random() * getHandCards().size());

        Card selectCard = getHandCard(randomSelect);
        removeHandCard(randomSelect);

        System.out.println(getName() + " 出的是 " + selectCard);

        return selectCard;
    }

}
