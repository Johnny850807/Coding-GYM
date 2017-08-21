package Furniture;

public class Fan {
	private Status status = Status.SMALL;
	
	public void turnLarge(){
		System.out.println("�q���վ�j�צ�: �j");
		this.status = Status.LARGE;
	}
	
	public void turnSmall(){
		System.out.println("�q���վ�j�צ�: �z");
		this.status = Status.SMALL;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public String getStatusToString(){
		return status.toString();
	}
	
	
	public enum Status{
		LARGE("�j�סG�j"), SMALL("�j�סG�p");
		
		private String status;
		private Status(String status){
			this.status = status;
		}
	}
	
}
