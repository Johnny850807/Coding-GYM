package rpg;

public class Hero extends Role{

    public Hero() {
        super.setHp(500);
        super.setMp(500);
        super.setAtk(70);
        super.setDef(40);
        super.setMdf(20);
    }

    @Override
    public String toString() {
        return "玩家目前狀態為[" + "生命值=" + super.getHp() + ", 魔力值=" + super.getMp() + ", 攻擊力=" + super.getAtk() + ", 防禦力=" + super.getDef() + ", 魔法防禦力=" + super.getDef() + ']';
    }
}
