package 零件工廠;

public class InsufficientPartsException extends Exception {
	
	@Override
	public String getMessage() {
	    return "零件不足";
	}
	
}
