import java.util.ArrayList;
import java.util.List;

public class Folder extends Item {
    private List<Item> children = new ArrayList<>();

    public Folder(String name,String path) {
        super.setName(name);
        super.setPath(path);
    }

    @Override
    public void addItem(Item item) {
        children.add(item);
    }

    @Override
    public void deleteItem(Item item) {
        children.remove(item);
    }

    @Override
    public List<Item> getChildren() {
        return children;
    }

}
