package Game;

public class Main_GameStart {

	public static void main(String[] args) {
		
		//���|
		Guild guild=new Guild();
		
		
		//�_�I�̭�
		warrior Andy=new warrior("Andy");
		Archer Roget=new Archer("Roget");
		
		//�V���|���U �n�����s����
		guild.register_Adventurers(Andy);
		guild.register_Adventurers(Roget);
		
		
		//�s���Ȭ��e
		guild.setmission("�s���� �����s�g������!!");
		guild.setmission("�s���� �H��o�����fŧ!!");

	}

}
