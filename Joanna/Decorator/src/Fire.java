
public class Fire extends TypeDecorator {

	public Fire(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "¤õ¨t" + pokemon.getDescription();
	}

}
