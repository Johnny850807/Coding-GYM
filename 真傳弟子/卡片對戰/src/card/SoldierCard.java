package card;

public class SoldierCard extends Card {
    public SoldierCard() {
        super("小兵");
    }

    @Override
    public DuelResult duel(Card card) {
        if (card instanceof KnightCard || card instanceof InfantryCard) {
            return DuelResult.LOSE;
        } else if (card instanceof GeneralCard) {
            return DuelResult.WIN;
        }
        return DuelResult.TIE;
    }

    @Override
    public String toString() {
        return getName();
    }
}
