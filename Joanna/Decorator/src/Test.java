
public class Test {

	public static void main(String[] args) {
		Pokemon pokemon1 = new Monster();
		pokemon1 = new Fire(pokemon1);
		pokemon1 = new Water(pokemon1);
		Pokemon pokemon2 = new Monster();
		pokemon2 = new Grass(pokemon2);

		int hurt = 100;
		System.out.println(pokemon1.getDescription() + "�J��" + pokemon2.getDescription() + "��l�¤O" + hurt);
		System.out.println(pokemon1.attack(pokemon2, hurt));
	}
	
}
