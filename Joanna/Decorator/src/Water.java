
public class Water extends TypeDecorator {

	public Water(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "¤ô¨t" + pokemon.getDescription();
	}

	@Override
	public float calculateHurt(Pokemon pokemon) {
		if (pokemon instanceof Grass)
			return 2;
		else if (pokemon instanceof Fire) 
			return .5f;
		else if (pokemon instanceof Water)
			return 1;
		return 0;
	}

}
