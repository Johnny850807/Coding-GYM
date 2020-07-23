/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class AbstractItem implements Item {
    protected Item parent;
    protected String name;

    public AbstractItem(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    @Override
    public boolean isHidden() {
        return getName().startsWith(".");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return String.format("%s/%s", parent.getPath(), getName())
                .replaceAll("//", "/"); // consolidate duplicated '/', this is the case when the parent is Root.
    }

    @Override
    public Item getParent() {
        return parent;
    }

    @Override
    public void setParent(Item parent) {
        this.parent = parent;
    }
}
