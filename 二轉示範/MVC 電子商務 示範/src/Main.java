import Controller.ECommerce;
import View.View;
import View.ViewImp;

public class Main {

	public static void main(String[] args) {
		ECommerce eCommerce = ECommerce.create();
		View view = new ViewImp(eCommerce);
		eCommerce.setView(view);
		view.onStart();
	}

}
