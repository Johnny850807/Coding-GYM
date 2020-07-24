import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class LocalDirectory extends AbstractItem implements Directory {
    private final Link ALIAS_THIS_DIR = new Link(".", () -> this);
    private final Link ALIAS_PARENT = new Link("..", this::getParent);
    private List<Item> children = new ArrayList<>(5);

    public LocalDirectory(String name) {
        super(name);
        for (Item item : onSetupChildren()) {
            add(item);
        }
    }

    /**
     * The hook for its subclass to add its children during instantiation.
     */
    protected List<Item> onSetupChildren() {
        return Arrays.asList(ALIAS_THIS_DIR, ALIAS_PARENT);
    }


    @Override
    public void add(Item item) {
        children.add(item);
        item.setParent(this);
    }

    @Override
    public void remove(Item item) {
        children.remove(item);
        item.setParent(null);
    }


    @Override
    public List<Item> getChildren() {
        return children;
    }

    @Override
    public Item getChild(String name) throws FileNotFoundException {
        return children.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst()
                .orElseThrow(() ->
                        new FileNotFoundException(
                                String.format("Cannot not find the file %s in %s.", name, getPath())));
    }

    @Override
    public List<Item> search(String keyword) {
        List<Item> result = new LinkedList<>();
        for (Item child : children) {
            if (child.getName().contains(keyword)) {
                result.add(child);
            }
            if (!(child instanceof Link)) {
                result.addAll(child.search(keyword));
            }
        }
        return result;
    }

    @Override
    public boolean contains(Item item) {
        return getChildren().contains(item) ||
                children.stream().anyMatch(child -> child.contains(item));
    }

    @Override
    public void acceptVisitor(ItemVisitor itemVisitor) {
        itemVisitor.visit(this);
    }


}
