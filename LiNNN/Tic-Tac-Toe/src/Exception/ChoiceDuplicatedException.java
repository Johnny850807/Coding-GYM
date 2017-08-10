package Exception;

public class ChoiceDuplicatedException extends Exception{

	@Override
	public String getMessage() {
		return "請勿選擇對方選過的格子";
	}
	
}
