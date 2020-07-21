package role.status;

import role.Role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class AbstractStatus implements Status {
    protected final Role role;

    public AbstractStatus(Role role) {
        this.role = role;
    }


}
