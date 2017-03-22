
public class BaseProperty implements Property{

	@Override
	public int getDamage(PropertyEnum pro, int damage) {
		//在此範例中，這個類別純粹只是做來基底，結束判定的點。
		return damage;
	}

}
