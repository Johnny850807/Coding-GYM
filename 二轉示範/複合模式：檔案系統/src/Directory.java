import java.util.List;

public interface Directory extends Item {
	void add(Item item);
	void remove(Item item);
	Item getChild(String name) throws FileNotFoundException;
	List<Item> getChildren();
}
