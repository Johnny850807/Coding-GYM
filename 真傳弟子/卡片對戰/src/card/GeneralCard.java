package card;

public class GeneralCard extends Card{
    public GeneralCard() {
        super("將軍");
    }

    @Override
    public DuelResult duel(Card card) {
        if(card instanceof KnightCard || card instanceof InfantryCard){
            return DuelResult.WIN;
        }else if(card instanceof GeneralCard){
            return DuelResult.TIE;
        }
        return DuelResult.LOSE;
    }

    @Override
    public String toString() {
        return getName();
    }
}
