package 自製資料結構;

public class StackEmptyException extends Exception {

	@Override
	public String getMessage() {
	    return "無法Pop，堆疊已經空了！";
	}
	
}
