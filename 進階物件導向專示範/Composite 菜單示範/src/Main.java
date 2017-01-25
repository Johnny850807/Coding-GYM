import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		MyMenuList<MealsGettable> myMenuList = new MyMenuList<MealsGettable>();
		
		MealsGettable firstRestaurant = new Building("�@�\");
		MealsGettable secondRestaurant = new Building("�G�\");
		MealsGettable bbNingVendor = new Vendor("BB��ڬ�����u");
		MealsGettable yellowMom = new Vendor("������");
		
		myMenuList.add(firstRestaurant).add(secondRestaurant)
		.add(bbNingVendor).add(yellowMom);
		
		/*�@�\*/
		
		MealsGettable italyVendor = new Vendor("�q�j�Q");
		italyVendor.addItem(new MenuItem("�f�X�q�j�Q��")).addItem(new MenuItem("�K�N�_�q��"));
		
		MealsGettable ironVendor = new Vendor("�K�O�\��");
		ironVendor.addItem(new MenuItem("�K�O����")).addItem(new MenuItem("�K�O��"));
		
		firstRestaurant.addItem(italyVendor).addItem(ironVendor);
		
		/*�G�\*/
		
		MealsGettable eightSquare = new Vendor("�K�足��");
		eightSquare.addItem(new MenuItem("�����l")).addItem(new MenuItem("�ɨ���l"));
		
		MealsGettable MyFamily = new Vendor("���a");
		
		MyFamily.addItem(new MenuCategory("���I��")
				.addItem(new MenuItem("�_�q�J�|"))
				.addItem(new MenuItem("ī�G�ѥ]")))
		.addItem(new MenuCategory("�L�i��")
				.addItem(new MenuItem("���ת���"))
				.addItem(new MenuItem("�ަ׻\��")));
		
		secondRestaurant.addItem(eightSquare).addItem(MyFamily);
		
		/*BB��ڬ�����u*/
		
		bbNingVendor.addItem(new MenuCategory("�{����")
				.addItem(new MenuItem("�{���j��"))
				.addItem(new MenuItem("�{���N����")))
		.addItem(new MenuCategory("�s��")
				.addItem(new MenuItem("�¤h��"))
				.addItem(new MenuItem("�x�W��s")));
		
		/*������*/
		
		yellowMom.addItem(new MenuItem("�ަ׻\��"))
		.addItem(new MenuItem("�J�]��"))
		.addItem(new MenuItem("�i�֦h"));
		
		myMenuList.printAllMenu();
	}

}
