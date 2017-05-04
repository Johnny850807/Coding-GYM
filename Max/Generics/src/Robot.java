
public class Robot implements Products{
	private final int consumption = 3;
	@Override
	public int getConsumption() {
		return consumption;
	}
	@Override
	public String toString(){
		return "Robot";
	}

	
}
