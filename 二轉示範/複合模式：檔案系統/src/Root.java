import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Root extends LocalDirectory {
    public Root() {
        super("");
    }

    @Override
    protected List<Item> onSetupChildren() {
        return Arrays.asList(
                new Link(".", () -> this),
                new Link("..", () -> this));
    }

    @Override
    public String getPath() {
        return "/";
    }
}
