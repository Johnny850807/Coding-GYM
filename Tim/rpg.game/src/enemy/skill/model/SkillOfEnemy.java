package enemy.skill.model;

public enum SkillOfEnemy {

    NORMAL_ATTACK("普通攻擊", 0, "一般攻擊"),
    LIGHTNING_SPELL("雷擊", 0, "消耗100點MP、造成魔法傷害250點"),
    SUMMONER_SPELLS("召喚", 0, "消耗50點MP、隨機場上增加一位敵人 (士兵、護衛隊 或 法師)");

    private String name;
    private int number;
    private String desc;

    SkillOfEnemy(String name, int number, String desc) {
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
