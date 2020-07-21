package role.decision;

import role.Role;

import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface TargetDecision {
    Role makeTargetDecision(List<Role> targets);
}
