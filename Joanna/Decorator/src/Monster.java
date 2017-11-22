
public class Monster implements Pokemon {
	
	@Override
	public int attack(Pokemon typeDecorator, int hurt) {
		return hurt;
	}

	@Override
	public String getDescription() {
		return "¯«©_Ä_¨©";
	}

}
