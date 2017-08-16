
public class StackEmptyException extends RuntimeException{

	@Override
	public String getMessage() {
		return "無法Pop，堆疊已經空了 !";
	}
	
}
