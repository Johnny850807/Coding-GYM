
public class TypeRestraint {

	public boolean judgeHurt(Pokemon pokemon1, Pokemon pokemon2) {
		if (pokemon1 instanceof Water && pokemon2 instanceof Grass)
			return false;
		if (pokemon1 instanceof Water && pokemon2 instanceof Fire) 
			return true;
		if (pokemon1 instanceof Grass && pokemon2 instanceof Fire) 
			return false;
		if (pokemon1 instanceof Grass && pokemon2 instanceof Water) 
			return true;
		if (pokemon1 instanceof Fire && pokemon2 instanceof Water) 
			return false;
		if (pokemon1 instanceof Fire && pokemon2 instanceof Grass)
			return true;
		return false;
	}
	
}
