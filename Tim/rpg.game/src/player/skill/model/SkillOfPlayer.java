package player.skill.model;

public enum SkillOfPlayer {
    NORMAL_ATTACK("普通攻擊", 0, "會抵銷對方的防禦力"),
    WATERBALL("水球", 1, "消耗50點MP、一次攻擊所有怪物，魔法傷害值 50"),
    FIREBALL("火球", 2, "消耗50點MP、攻擊一隻怪物，魔法傷害值 150"),
    ADDDEFENSE("強化自身", 3, "消耗40點MP、提高自身防禦力30"),
    FREEZE("凍結", 4, "消耗100點MP、讓一個敵人無法行動3回合");

    private String name;
    private int number;
    private String desc;

    SkillOfPlayer(String name, int number, String desc) {
        this.name = name;
        this.number = number;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDesc() {
        return desc;
    }
}
