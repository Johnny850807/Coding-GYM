package LoginSystem;

import java.io.PrintStream;

public class PairInfoNotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "�b�K���ŦX";
	}
	
	@Override
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
	}

}
