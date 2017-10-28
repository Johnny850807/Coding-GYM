package test;

import app.Activity;

public class Main {

	public static void main(String[] args) {
		new MainActivity().start();
		Activity.getTopActivity().trigger();
		Activity.getTopActivity().trigger(); 
	}

}
