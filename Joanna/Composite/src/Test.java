
public class Test {

	public static void main(String[] args) {
		Building building1 = new Building("�@�\");
		Shop shop1 = new Shop("�q�j�Q�\�]");
		Shop shop2 = new Shop("�K�O�\�]");
		MenuItem item = new MenuItem("����");
		MenuItem item2 = new MenuItem("�K�O����");
		building1.add(shop1);
		building1.add(shop2);
		shop1.add(item);
		shop2.add(item);
		shop2.add(item2);
		building1.display();
	}

}
