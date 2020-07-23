import java.util.List;

public interface Item {
    String getName();

    String getPath();

    boolean isHidden();

    List<Item> search(String keyword);

    boolean contains(Item item);

    void setParent(Item item);

    Item getParent();

    void acceptVisitor(ItemVisitor itemVisitor);
}
