
public class Grass extends TypeDecorator {

	public Grass(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "¯ó¨t" + pokemon.getDescription();
	}

	@Override
	public float calculateHurt(Pokemon pokemon) {
		if (pokemon instanceof Fire)
			return 2;
		else if (pokemon instanceof Water) 
			return .5f;
		else if (pokemon instanceof Grass)
			return 1;
		return 0;
	}
	
}
