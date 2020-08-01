import java.util.List;

public class Link extends Item {
    private Item link;

    public Link(String name, String path,Item item , String rootName) {
        super.setName(name);
        super.setPath(path);
        super.setRootName(rootName);
        link = item;
    }

    public List<Item> getChildren() {
        return null;
    }
}
