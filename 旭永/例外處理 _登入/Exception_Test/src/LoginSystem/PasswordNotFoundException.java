package LoginSystem;

import java.io.PrintStream;

public class PasswordNotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "±K½X¤£²Å¦X";
	}
	
	@Override
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
	}

}
