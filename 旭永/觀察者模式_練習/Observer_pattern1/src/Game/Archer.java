package Game;

public class Archer implements Observer {
	
	private String name;
	
		public Archer(String name){
			this.name=name;
		}
	
		
		@Override
		public void updata(String mission) {
			System.out.println("�}�b�� "+name+" ����s����:"+mission);		
		}

}