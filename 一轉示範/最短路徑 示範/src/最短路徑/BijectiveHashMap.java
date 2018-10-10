package ³Ìµu¸ô®|;

import java.util.HashMap;

public class BijectiveHashMap <T1, T2>{
	private HashMap<T1, T2> toMap = new HashMap<>();
	private HashMap<T2, T1> reMap = new HashMap<>();
	
	public void put(T1 t1, T2 t2){
		toMap.put(t1, t2);
		reMap.put(t2, t1);
	}
	
	public T2 getValue(T1 t1){
		return toMap.get(t1);
	}
	
	public T1 getKey(T2 t2){
		return reMap.get(t2);
	}
	
	public void clear(){
		toMap.clear();
		reMap.clear();
	}
}
