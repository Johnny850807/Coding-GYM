package Game;

public class warrior implements Observer {

	private String name;
		
		public warrior(String name){
			this.name=name;
		}
		
		
		@Override
		public void updata(String mission) {
			System.out.println("�Ԥh"+name+ "����s����:"+mission);		
		}

}
