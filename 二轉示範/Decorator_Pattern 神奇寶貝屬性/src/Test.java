
public class Test {

	public static void main(String[] argv){
		//��+���ݩ�
		Property property = new Water ( new Fire ( new BaseProperty() ) );
		PokeMon monster = new PokeMon("������",property);
		System.out.println(monster.getName()+"�����t����..��l�¤O100");
		int damage = monster.getAttack(PropertyEnum.GRASS, 100); //�Q��t����
		System.out.println("�ˮ`�̲קP�w��... "+damage);
	}

}
