package card;

public class InfantryCard extends Card {
    public InfantryCard() {
        super("步兵");
    }

    @Override
    public DuelResult duel(Card card) {
        if (card instanceof GeneralCard || card instanceof KnightCard) {
            return DuelResult.LOSE;
        } else if (card instanceof SoldierCard) {
            return DuelResult.WIN;
        }
        return DuelResult.TIE;
    }

    @Override
    public String toString() {
        return getName();
    }
}
