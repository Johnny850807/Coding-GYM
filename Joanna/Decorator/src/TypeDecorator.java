
public abstract class TypeDecorator implements Pokemon{

	protected Pokemon pokemon;
	
	public TypeDecorator(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	@Override
	public int attack(Pokemon typeDecorator, int hurt) {
		double addition = calculateHurt(typeDecorator, this);
		String status = "";
		if (addition > 1) 
			status = "Double!";
		else if (addition < 1)
			status = "Half!";
		System.out.println(typeDecorator.getClass().getName() + " vs " + this.getClass().getName() +  " " + status);
		return pokemon.attack(typeDecorator, (int) (hurt * addition));
	}
	
	public double calculateHurt(Pokemon pokemon1, Pokemon pokemon2) {
		if (pokemon1 instanceof Water && pokemon2 instanceof Grass)
			return 0.5;
		if (pokemon1 instanceof Water && pokemon2 instanceof Fire) 
			return 2;
		if (pokemon1 instanceof Grass && pokemon2 instanceof Fire) 
			return 0.5;
		if (pokemon1 instanceof Grass && pokemon2 instanceof Water) 
			return 2;
		if (pokemon1 instanceof Fire && pokemon2 instanceof Water) 
			return 0.5;
		if (pokemon1 instanceof Fire && pokemon2 instanceof Grass)
			return 2;
		return 1;
	}
	
}
