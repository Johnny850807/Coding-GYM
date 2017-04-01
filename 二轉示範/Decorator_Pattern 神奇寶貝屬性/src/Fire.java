
public class Fire extends PropertyDecorator {
	public Fire(Property pro){
		super(pro);
	}


	@Override
	public int getDamage(PropertyEnum pro, int damage) {
		// �P�w�ˮ` 
		switch(pro){
			case WATER:  
				System.out.println("�����..�ˮ`�[��");
				return property.getDamage(pro, (int)(damage * 2));
			case FIRE: 
				System.out.println("�����..�ˮ`��b");
				return property.getDamage(pro, (int)(damage * 0.5));
			case GRASS:  
				System.out.println("����..�ˮ`��b");
				return property.getDamage(pro, (int)(damage * 0.5));
				
		}
		return 1;
	}
	
}
