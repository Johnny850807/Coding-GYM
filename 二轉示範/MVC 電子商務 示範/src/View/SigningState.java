package View;

import Util.Input;

public class SigningState extends State{

	public SigningState(View view) {
		super(view);
	}

	@Override
	public void showUi() {
		int type = Input.nextInt("(1) µù¥U  (2) µn¤J : ",1 ,2);
		switch (type) {
		case 1:
			view.getEcommerce().register(Input.nextLine("¦WºÙ¡G"), Input.nextLine("±b¸¹¡G"), 
					Input.nextLine("±K½X¡G"));
			break;
		default:
			view.getEcommerce().signIn(Input.nextLine("±b¸¹¡G"), 
					Input.nextLine("±K½X¡G"));
		}
		
	}

	@Override
	public void finish() {
		System.exit(1);
	}

}
