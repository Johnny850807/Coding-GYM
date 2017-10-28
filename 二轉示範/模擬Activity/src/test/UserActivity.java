package test;

import app.Activity;
import app.Intent;

public class UserActivity extends Activity{
	private String userName;
	
	@Override
	protected void onCreate() {
		super.onCreate();
		Intent intent = getIntent();
		userName = intent.getString("name");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("Resuming ...");
	}
	
	@Override
	public void trigger() {
		System.out.println("User name: " + userName);
		System.out.println("The user activity being closed...");
		finish();
	}
	
}
