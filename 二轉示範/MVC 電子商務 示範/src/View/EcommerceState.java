package View;

import java.util.Scanner;

import Model.User;

public class EcommerceState extends State{
	private User user;
	public EcommerceState(User user, View view) {
		super(view);
		this.user = user;
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) �[�ݤw�ʶR�ӫ~ (2) �ʶR�ӫ~ (3) �n�X" ,1 ,3);
		switch (type) {
		case 1:
			user.showProducts();
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
