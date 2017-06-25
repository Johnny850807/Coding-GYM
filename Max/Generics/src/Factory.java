import java.util.ArrayList;
import java.util.HashMap;

public class Factory<C extends Components , P extends Products> {
	private int componentAmount;
	private HashMap map;
	private String name = "";
	public Factory(){
		init();
	}
	private void init(){
		map = new HashMap();
		componentAmount = 0;
	}
	public void addComponent(C c){
		System.out.println("加入零件 " + c.getName());
		if(name.equals("")){
			name = c.getName();
			map.put(name, ++componentAmount);
		}
		else{
			map.put(name, ++componentAmount);
		}
		
	}
	public void generateProduct(P p){
			try{
				if(componentAmount < p.getConsumption()){
					throw new AmountException(p.getConsumption());
				}
				else{
					componentAmount -= p.getConsumption();
					map.put(name, componentAmount);
					System.out.println("生產 " + p.toString() + "乙台");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
	}
	public void print(){
		System.out.println( "零件 " + map.keySet()  + "目前有 : " + map.values() + " 個 " );
	}
}
