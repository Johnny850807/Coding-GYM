package Exception;

public class StackEmptyException extends RuntimeException{

	@Override
	public String getMessage() {
		return "無法pop，堆疊已經空了!";
	}
	
}
