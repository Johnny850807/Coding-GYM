package View;

import Util.Input;

public class SigningState extends State{

	public SigningState(View view) {
		super(view);
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) ���U  (2) �n�J : ",1 ,2);
		switch (type) {
		case 1:
			view.getEcommerce().register(Input.nextLine("�W�١G"), Input.nextLine("�b���G"), 
					Input.nextLine("�K�X�G"));
			break;
		default:
			view.getEcommerce().signIn(Input.nextLine("�b���G"), 
					Input.nextLine("�K�X�G"));
		}
		
	}

	@Override
	public void finish() {
		System.exit(1);
	}

}
