package card;

public class KnightCard extends Card {
    public KnightCard() {
        super("騎士");
    }

    @Override
    public DuelResult duel(Card card) {
        if (card instanceof SoldierCard || card instanceof InfantryCard) {
            return DuelResult.WIN;
        } else if (card instanceof GeneralCard) {
            return DuelResult.LOSE;
        }
        return DuelResult.TIE;
    }

    @Override
    public String toString() {
        return getName();
    }
}
