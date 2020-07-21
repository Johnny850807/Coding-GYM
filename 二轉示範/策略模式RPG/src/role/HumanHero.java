package role;

import skills.普通攻擊;
import skills.Skill;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class HumanHero extends Role {
    private final Scanner in = new Scanner(System.in);
    private int basicAttackNumber = -1;

    public HumanHero(String name, Capability capability, Skill... skills) {
        super(name, capability, skills);
        locateBasicAttack(skills);
    }


    private void locateBasicAttack(Skill[] skills) {
        for (int i = 0; i < skills.length; i++) {
            Skill skill = skills[i];
            if (skill instanceof 普通攻擊) {
                basicAttackNumber = i;
            }
        }
        if (basicAttackNumber == -1) {
            throw new IllegalStateException("Hero must have a BasicAttack skill.");
        }
    }

    @Override
    public void makeMoveDecision() {
        int choice = inputNumber(1, 2, "請選擇 (1) 普通攻擊 (2) 使用技能: ");
        switch (choice) {
            case 1:
                useSkill(basicAttackNumber);
                break;
            case 2:
                makeSkillsDecision();
                break;
        }
    }

    private void makeSkillsDecision() {
        StringBuilder messageBuilder = new StringBuilder("請選擇你要使用的技能 (輸入-1返回)：");
        String skillsPrint = IntStream.range(0, getSkills().length)
                .mapToObj(num -> String.format("(%d) %s (MP: %d)", num, getSkill(num).getName(), getSkill(num).getRequiredMP()))
                .collect(Collectors.joining("\n"));
        messageBuilder.append(skillsPrint);

        int choice = inputNumber(-1, getSkills().length - 1, messageBuilder.toString());
        if (choice == -1) {
            makeMoveDecision();
        } else {
            try {
                useSkill(choice);
            } catch (MagicNotEnoughException err) {
                System.err.println("魔力不足！");
                makeSkillsDecision();
            }
        }
    }

    @Override
    public Role makeTargetDecision(List<Role> targets) {
        StringBuilder messageBuilder = new StringBuilder("請選擇對象： ");
        String targetsPrint = IntStream.range(0, targets.size())
                .mapToObj(num -> String.format("(%d) %s ", num, targets.get(num)))
                .collect(Collectors.joining("\n"));
        messageBuilder.append(targetsPrint);

        int choice = inputNumber(0, targets.size() - 1, messageBuilder.toString());
        return targets.get(choice);
    }


    private int inputNumber(int validStart, int validEnd, String message) {
        System.out.println(message);
        try {
            int num = in.nextInt();
            if (num >= validStart && num <= validEnd) {
                return num;
            } else {
                System.err.printf("只能輸入範圍 %d ~ %d 的數字。\n", validStart, validEnd);
                return inputNumber(validStart, validEnd, message);
            }
        } catch (InputMismatchException err) {
            System.err.println("請輸入數字！");
            return inputNumber(validStart, validEnd, message);
        }
    }
}
