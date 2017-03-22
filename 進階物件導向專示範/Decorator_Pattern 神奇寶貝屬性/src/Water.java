
public class Water extends PropertyDecorator {
	public Water(Property pro) {
		super(pro);
	}

	@Override
	public int getDamage(PropertyEnum pro, int damage) {
		// 判定傷害 
		switch(pro){
			case WATER:  
				System.out.println("水對水 傷害減半");
				return property.getDamage(pro, (int)(damage * 0.5));
			case FIRE:  
				System.out.println("火對水 傷害減半");
				return property.getDamage(pro, (int)(damage * 0.5));
			case GRASS:  
				System.out.println("草對水..傷害加倍");
				return property.getDamage(pro, damage * 2);
				
		}
		return 1;
	}
	
}
