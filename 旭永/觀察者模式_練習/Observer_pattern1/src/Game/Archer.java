package Game;

public class Archer implements Observer {
	
	private String name;
	
		public Archer(String name){
			this.name=name;
		}
	
		
		@Override
		public void updata(String mission) {
			System.out.println("弓箭手 "+name+" 收到新任務:"+mission);		
		}

}