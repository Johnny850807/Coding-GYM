
public abstract class TypeDecorator implements Pokemon{

	protected Pokemon pokemon;
	
	public TypeDecorator(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	@Override
	public int attack(Pokemon typeDecorator, int hurt) {
		float addition = calculateHurt(typeDecorator);
		String status = "";
		if (addition > 1) 
			status = "Double!";
		else if (addition < 1)
			status = "Half!";
		System.out.println(typeDecorator.getClass().getName() + " vs " + this.getClass().getName() +  " " + status);
		return pokemon.attack(typeDecorator, (int) (hurt * addition));
	}
	
	public abstract float calculateHurt(Pokemon pokemon);
	
}
