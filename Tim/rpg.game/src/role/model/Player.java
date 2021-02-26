package role.model;

import enemy.skill.model.Skill;
import player.skill.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class Player extends Role {
    protected Skill normalAttack;
    protected Skill waterBallSkill;
    protected Skill fireBallSkill;
    protected Skill addDefenseSkill;
    protected Skill freezeSkill;

    public Player() {
        super("英雄", 500, 500, 70, 40, 10);
        waterBallSkill = new WaterBallSkill();
        fireBallSkill = new FireBallSkill();
        addDefenseSkill = new AddDefenseSkill();
        freezeSkill = new FreezeSkill();
        normalAttack = new NormalAttack();
    }

    @Override
    public void action(Round round) {
        Arrays.stream(SkillOfPlayer.values()).forEach(skillOfPlayer -> System.out.println(skillOfPlayer.getNumber() + ") " + skillOfPlayer.getName()+" = "+skillOfPlayer.getDesc()));
        while (true) {
            System.out.println("請選擇技能?");
            Scanner scanner = new Scanner(System.in);
            int skillNumber = scanner.nextInt();
            boolean skillsAble = false;
            switch (skillNumber) {
                case 0:
                    skillsAble = this.normalAttack.use(round);
                    break;
                case 1:
                    skillsAble = this.waterBallSkill.use(round);
                    break;
                case 2:
                    skillsAble = this.fireBallSkill.use(round);
                    break;
                case 3:
                    skillsAble = this.addDefenseSkill.use(round);
                    break;
                case 4:
                    skillsAble = this.freezeSkill.use(round);
                    break;

                default:
            }
            if (skillsAble) {
                break;
            }
        }
    }
}
