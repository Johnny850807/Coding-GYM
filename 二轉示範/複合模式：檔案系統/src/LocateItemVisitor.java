import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class LocateItemVisitor implements ItemVisitor {
    private final Directory root;
    private final Directory currentDir;

    private StringTokenizer pathTokenizer;
    private Directory parent;
    private Item item;
    private FileNotFoundException fileNotFoundException;
    private String itemName;
    private String absolutePath;

    public LocateItemVisitor(Directory root, Directory currentDir) {
        this.root = root;
        this.currentDir = currentDir;
    }


    public void locateItemFromPath(String path) {
        pathTokenizer = new StringTokenizer(path, "/");
        if (path.startsWith("/")) {
            root.acceptVisitor(this); // absolute path
        } else {
            currentDir.acceptVisitor(this);
        }
    }


    @Override
    public void visit(Directory directory) {
        // 'remains 1 token' means the visit is left the final child,
        // and thus this directory is its parent
        if (pathTokenizer.countTokens() == 1) {
            parent = directory;
        }
        visitNextChild(directory);
    }

    private void visitNextChild(Directory directory) {
        if (pathTokenizer.hasMoreTokens()) {
            String childName = pathTokenizer.nextToken();
            try {
                directory.getChild(childName)
                        .acceptVisitor(this);
            } catch (FileNotFoundException err) {
                this.fileNotFoundException = err;
                this.itemName = childName;
            }
        } else {
            this.item = directory;
            this.itemName = directory.getName();
        }
    }

    @Override
    public void visit(Item item) {
        // expect no more tokens while the visit comes to the non-directory item
        // so skip the middle path until reach the final item, fetch the item's name and then throw an exception
        if (pathTokenizer.hasMoreTokens()) {
            while(pathTokenizer.hasMoreTokens()) {
                this.itemName = pathTokenizer.nextToken();
            }
            throw new IllegalArgumentException(
                    String.format("Path invalid, the segment named %s in the path is not a directory.", item.getName()));
        } else {
            this.item = item;
            this.itemName = item.getName();
        }
    }

    public Directory getParent() {
        return parent;
    }

    public Item getItem() throws FileNotFoundException {
        if (item == null) {
            throw fileNotFoundException;
        } else {
            return item;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public String getAbsoluteItemPath() {
        return (getParent().getPath() + "/" + itemName)
                .replaceAll("//", "/");
    }
}
