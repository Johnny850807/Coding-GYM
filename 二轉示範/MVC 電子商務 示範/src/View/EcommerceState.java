package View;

import Model.User;
import Util.Input;

public class EcommerceState extends State{
	public EcommerceState(View view) {
		super(view);
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) �[�ݤw�ʶR�ӫ~ (2) �ʶR�ӫ~ (3) �n�X" ,1 ,3);
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
