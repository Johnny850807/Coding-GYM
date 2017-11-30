
public class Fire extends TypeDecorator {

	public Fire(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "¤õ¨t" + pokemon.getDescription();
	}

	@Override
	public float calculateHurt(Pokemon pokemon) {
		if (pokemon instanceof Water)
			return 2;
		else if (pokemon instanceof Grass) 
			return .5f;
		else if (pokemon instanceof Fire)
			return 1;
		return 0;
	}
	
}
