import java.util.List;

public abstract class Item {
    private String name;
    private String content;
    private String path;
    private String rootName;

    public String getName(){
        return name;
    };

    public void addItem(Item item){
        throw new UnsupportedOperationException();
    }

    public void deleteItem(Item item){
        throw new UnsupportedOperationException();
    }

    public  List<Item> getChildren(){
        throw new UnsupportedOperationException();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }
}
