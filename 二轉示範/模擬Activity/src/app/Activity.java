package app;

import java.lang.reflect.Field;
import java.util.Stack;

public abstract class Activity {
	private static Stack<Activity> activityStack = new Stack<>();
	private Intent intent;
	
	protected Activity(){
		activityStack.push(this);
	}
	
	public void start(){
		onCreate();
	}
	
	protected void onCreate(){
		System.out.println("Activity " + getClass().getSimpleName() + " OnCreate");
		onStart();
	}
	
	protected void onStart(){
		System.out.println("Activity " + getClass().getSimpleName() + " OnStart");	
		onResume();
	}
	
	protected void onResume(){
		System.out.println("Activity " + getClass().getSimpleName() + " OnResume");	
	}
	
	protected void onRestart(){		
		System.out.println("Activity " + getClass().getSimpleName() + " OnRestart");	
		onStart();
	}
	
	protected void onPause(){
		System.out.println("Activity " + getClass().getSimpleName() + " onPause");	
		onStop();
	}
	
	protected void onStop(){
		System.out.println("Activity " + getClass().getSimpleName() + " onStop");	
	}
	
	protected void onDestroy(){
		System.out.println("Activity " + getClass().getSimpleName() + " onDestroy");	
	}
	
	protected final void startActivity(Intent intent){
		try {
			Class<? extends Activity> target = intent.getTargetActivityClass();
			Activity newActivity = target.newInstance();
			setIntentToNewActivityByReflection(newActivity, intent);
			newActivity.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setIntentToNewActivityByReflection(Activity newActivity, Intent intent) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field intentField = Activity.class.getDeclaredField("intent");
		boolean accessible = intentField.isAccessible();
		intentField.setAccessible(true);
		intentField.set(newActivity, intent);
		intentField.setAccessible(accessible);
	}
	
	protected final void finish(){
		boolean isTopActivity = activityStack.indexOf(this) ==  activityStack.size() - 1;
		onPause();
		activityStack.remove(this);
		onDestroy();
		
		// restart the next activity from the top if the finished activity is at the top of the stack.
		if (isTopActivity)
		{
			Activity next = activityStack.peek();
			next.onRestart();
		}
	}
	
	public Intent getIntent() {
		return intent;
	}
	
	public abstract void trigger();
	
	public static Activity getTopActivity(){
		return activityStack.peek();
	}
	
}
