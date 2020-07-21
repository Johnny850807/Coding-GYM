package role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Capability implements Cloneable {
    public int hp;
    public int mp;
    public int attackPoint;
    public int defence;
    public int magicDefence;

    public Capability(int hp, int mp, int attackPoint, int defence, int magicDefence) {
        this.hp = hp;
        this.mp = mp;
        this.attackPoint = attackPoint;
        this.defence = defence;
        this.magicDefence = magicDefence;
    }

    public Capability clone() {
        try {
            return (Capability) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Impossible", e);
        }
    }

    @Override
    public String toString() {
        return String.format("HP: %d, MP: %d, AP: %d, DF: %d, MDF: %d", hp, mp, attackPoint, defence, magicDefence);
    }
}
