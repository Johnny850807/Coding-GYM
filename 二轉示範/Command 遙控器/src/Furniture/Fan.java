package Furniture;

public class Fan {
	private Status status = Status.SMALL;
	
	public void turnLarge(){
		System.out.println("電扇調整強度至: 強");
		this.status = Status.LARGE;
	}
	
	public void turnSmall(){
		System.out.println("電扇調整強度至: 弱");
		this.status = Status.SMALL;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public String getStatusToString(){
		return status.toString();
	}
	
	
	public enum Status{
		LARGE("強度：大"), SMALL("強度：小");
		
		private String status;
		private Status(String status){
			this.status = status;
		}
	}
	
}
