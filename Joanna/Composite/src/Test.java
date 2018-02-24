
public class Test {

	public static void main(String[] args) {
		Building building1 = new Building("¤@À\");
		Shop shop1 = new Shop("¸q¤j§QÀ\À]");
		Shop shop2 = new Shop("ÅKªOÀ\À]");
		MenuItem item = new MenuItem("¤ô»å");
		MenuItem item2 = new MenuItem("ÅKªO¤û¦×");
		building1.add(shop1);
		building1.add(shop2);
		shop1.add(item);
		shop2.add(item);
		shop2.add(item2);
		building1.display();
	}

}
