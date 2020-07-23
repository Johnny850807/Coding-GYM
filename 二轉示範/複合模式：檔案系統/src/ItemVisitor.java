/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface ItemVisitor {
    void visit(Directory directory);

    void visit(Item item);
}
