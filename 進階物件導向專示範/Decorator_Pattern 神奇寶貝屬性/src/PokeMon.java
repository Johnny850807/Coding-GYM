
public class PokeMon {
	private String name;  //名子
	private Property property; //神奇寶貝的屬性(水、火、水+火...)
	private int hp;

	public PokeMon(String name, Property property) {
		super();
		this.name = name;
		this.property = property;
	}

	public int getAttack(PropertyEnum pro , int damage ){
		//生命扣掉傷害判定的結果值
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
