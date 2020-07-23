import java.util.Collections;
import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class LocalFile extends AbstractItem implements File {
    private final byte[] content;

    public LocalFile(String name, byte[] content) {
        super(name);
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        return content;
    }

    @Override
    public List<Item> search(String keyword) {
        // file doesn't have any children, thus just return an empty list as the search result
        return Collections.emptyList();
    }

    @Override
    public boolean contains(Item item) {
        return false;
    }

    @Override
    public void acceptVisitor(ItemVisitor itemVisitor) {
        itemVisitor.visit(this);
    }

}
