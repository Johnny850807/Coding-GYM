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
		int type = Input.nextInt("(1) �[�ݤw�R�ӫ~�C��  (2) �ʶR�ӫ~ : (3) �n�X",1 ,3);
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
