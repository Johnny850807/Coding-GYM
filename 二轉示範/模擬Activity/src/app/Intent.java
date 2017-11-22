package app;

import java.util.HashMap;
import java.util.Map;

public final class Intent {
	private String action;
	private Activity from;
	private Class<? extends Activity> targetActivity;
	private Map<String, String> stringData = new HashMap<>();
	
	public Intent(Activity from, Class<? extends Activity> to){
		this.from = from;
		this.targetActivity = to;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public void putString(String key, String value){
		stringData.put(key, value);
	}
	
	public String getString(String key){
		return stringData.get(key);
	}
	
	protected Class<? extends Activity> getTargetActivityClass(){
		return targetActivity;
	}
	
	public Activity getPausedActivity(){
		return from;
	}
}
