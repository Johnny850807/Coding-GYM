
public class PokeMon {
	private String name;  //�W�l
	private Property property; //���_�_�����ݩ�(���B���B��+��...)
	private int hp;

	public PokeMon(String name, Property property) {
		super();
		this.name = name;
		this.property = property;
	}

	public int getAttack(PropertyEnum pro , int damage ){
		//�ͩR�����ˮ`�P�w�����G��
		int damageSum = property.getDamage(pro, damage);
		hp -= damageSum;
		return damageSum ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	
}	
