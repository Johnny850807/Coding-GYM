package test;

import java.util.Scanner;

import app.Activity;
import app.Intent;

public class MainActivity extends Activity{
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	protected void onCreate() {
		super.onCreate();
		System.out.println("Hi !");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("Restarted !");
	}
	
	@Override
	public void trigger() {
		System.out.println("Button on click, input the user's name: ");
		String name = scanner.nextLine();
		System.out.println("Completed, let's go to the next activity.");
		Intent intent = new Intent(this, UserActivity.class);
		intent.putString("name", name);
		startActivity(intent);
	}
	
}
