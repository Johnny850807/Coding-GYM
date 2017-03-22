
public class Fire extends PropertyDecorator {
	public Fire(Property pro){
		super(pro);
	}


	@Override
	public int getDamage(PropertyEnum pro, int damage) {
		// §P©w¶Ë®` 
		switch(pro){
			case WATER:  
				System.out.println("¤ô¹ï¤õ..¶Ë®`¥[­¿");
				return property.getDamage(pro, (int)(damage * 2));
			case FIRE: 
				System.out.println("¤õ¹ï¤õ..¶Ë®`´î¥b");
				return property.getDamage(pro, (int)(damage * 0.5));
			case GRASS:  
				System.out.println("¯ó¹ï¤õ..¶Ë®`´î¥b");
				return property.getDamage(pro, (int)(damage * 0.5));
				
		}
		return 1;
	}
	
}
