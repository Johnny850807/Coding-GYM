
public class Fire extends TypeDecorator {

	public Fire(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "���t" + pokemon.getDescription();
	}

}
