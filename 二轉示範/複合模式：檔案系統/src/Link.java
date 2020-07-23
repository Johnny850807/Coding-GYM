import java.util.List;
import java.util.function.Supplier;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Link extends AbstractItem implements Item {

    /**
     * There are two ways of linking, either by (root, targetPath) or by a targetItemSupplier
     */
    private Directory root;
    private String targetPath;

    private Supplier<Item> targetItemSupplier;

    public Link(Directory root, String name, String targetPath) {
        super(name);
        this.root = root;
        validateTargetPath(targetPath);
        this.targetPath = targetPath;
    }

    private void validateTargetPath(String targetPath) {
        if (!targetPath.startsWith("/")) {
            throw new IllegalArgumentException(String.format("Link only accepts absolute path, given %s.", targetPath));
        }
    }

    public Link(String name, Supplier<Item> targetItemSupplier) {
        super(name);
        this.targetItemSupplier = targetItemSupplier;
    }

    public List<Item> search(String keyword) {
        return locateTargetItem().search(keyword);
    }

    @Override
    public boolean contains(Item item) {
        return locateTargetItem().contains(item);
    }

    @Override
    public void acceptVisitor(ItemVisitor itemVisitor) {
        locateTargetItem().acceptVisitor(itemVisitor);
    }

    private Item locateTargetItem() {
        if (targetItemSupplier != null) {
            return targetItemSupplier.get();
        } else {
            return locateTargetItemFromTargetPath();
        }
    }

    private Item locateTargetItemFromTargetPath() {
        LocateItemVisitor visitor = new LocateItemVisitor(root,
                null /* no need for the 2nd param, since Link always use the absolute path*/);
        visitor.locateItemFromPath(targetPath);
        return visitor.getItem();
    }

}
