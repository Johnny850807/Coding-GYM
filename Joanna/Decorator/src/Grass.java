
public class Grass extends TypeDecorator {

	public Grass(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "��t" + pokemon.getDescription();
	}

}
