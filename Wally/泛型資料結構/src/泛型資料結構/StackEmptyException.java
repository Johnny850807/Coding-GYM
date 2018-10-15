package 泛型資料結構;

public class StackEmptyException extends RuntimeException {

	public StackEmptyException() {
	}
	
	public String getMessage() {
		return ("\n東西都啪出來了");
	}
}
