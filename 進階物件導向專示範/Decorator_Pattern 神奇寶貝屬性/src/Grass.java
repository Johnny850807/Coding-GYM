
public class Grass extends PropertyDecorator {
	Grass(Property pro) {
		super(pro);
	}

	@Override
	public int getDamage(PropertyEnum pro, int damage) {
		// §P©w¶Ë®` 
		switch(pro){
			case WATER:  
				System.out.println("¯ó¹ï¤ô ¶Ë®`´î¥b");
				return property.getDamage(pro, (int)(damage * 0.5));
			case FIRE:  
				System.out.println("¯ó¹ï¤õ ¶Ë®`¥[­¿");
				return property.getDamage(pro, (int)(damage * 2));
			case GRASS:  
				System.out.println("¯ó¹ï¯ó ¶Ë®`´î¥b");
				return property.getDamage(pro, (int)(damage * 0.5));
				
		}
		return 1;
	}
	
}
