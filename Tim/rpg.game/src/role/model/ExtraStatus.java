package role.model;

import java.util.ArrayList;
import java.util.List;

public class ExtraStatus {

    private final List<SkillExtraDamage> skillExtraDamages = new ArrayList<>();

    public List<SkillExtraDamage> getSkillExtraDamages() {
        return this.skillExtraDamages;
    }

    public void add(SkillExtraDamage skillExtraDamage) {
        skillExtraDamages.add(skillExtraDamage);
    }

}
