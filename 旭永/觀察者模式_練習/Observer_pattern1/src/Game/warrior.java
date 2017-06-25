package Game;

public class warrior implements Observer {

	private String name;
		
		public warrior(String name){
			this.name=name;
		}
		
		
		@Override
		public void updata(String mission) {
			System.out.println("戰士"+name+ "收到新任務:"+mission);		
		}

}
