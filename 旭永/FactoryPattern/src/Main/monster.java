package Main;

public class monster {
	
	private int HP =4000;
	
	
	public int gethurt(int damage){
		HP =HP -damage;
		return HP;		
	}

	
	public int HP(){
		return HP;		
	}
	
	public boolean isdead(){
		
		if(HP<=0){
			System.out.println("�Ǫ��w�� ���ƿN��");
			return true;
		}

		return false;
	}
}
