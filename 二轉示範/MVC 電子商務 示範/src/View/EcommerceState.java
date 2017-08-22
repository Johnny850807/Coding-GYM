package View;

import Model.User;
import Util.Input;

public class EcommerceState extends State{
	public EcommerceState(View view) {
		super(view);
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) 觀看已購買商品 (2) 購買商品 (3) 登出" ,1 ,3);
		switch (type) {
		case 1:
			view.getUser().showProducts();
			view.onShowUserProductsFinish();
			break;
		case 2:
			view.getEcommerce().showProducts();
			break;	
		default:
			finish();
		}
	}
	

	@Override
	public void finish() {
		view.getEcommerce().reset();
		SigningState state = new SigningState(view);
		view.setState(state);
		state.showUi();
	}

}
