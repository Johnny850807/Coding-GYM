
public class Test {

	public static void main(String[] argv){
		//水+火屬性
		Property property = new Water ( new Fire ( new BaseProperty() ) );
		PokeMon monster = new PokeMon("水火怪",property);
		System.out.println(monster.getName()+"受到草系攻擊..初始威力100");
		int damage = monster.getAttack(PropertyEnum.GRASS, 100); //被草系攻擊
		System.out.println("傷害最終判定為... "+damage);
	}

}
