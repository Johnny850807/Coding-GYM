package View;

import Model.User;
import Util.Input;

public class EcommerceState extends State{
	private User user;
	public EcommerceState(User user, View view) {
		super(view);
		this.user = user;
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) 觀看已買商品列表  (2) 購買商品 : (3) 登出",1 ,3);
		switch (type) {
		case 1:
			view.getEcommerce().showProducts();
			break;
		case 2:
			
			break;	
		default:
			finish();
		}
	}

	@Override
	public void finish() {
		view.getEcommerce().reset();
		view.setState(new SigningState(view));
	}

}
