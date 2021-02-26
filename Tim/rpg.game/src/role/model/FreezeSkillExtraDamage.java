package role.model;

public class FreezeSkillExtraDamage extends SkillExtraDamage {
    private int stopStatus = 3;

    @Override
    public void effect(Role role) {
        stopStatus--;
        System.out.println(stopStatus == 0 ? "冰凍傷害結束 " : "冰凍效果無法移動 " + stopStatus);
    }

    @Override
    public boolean isAble() {
        return stopStatus == 0;
    }
}
