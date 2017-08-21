package View;

public abstract class State {
	protected View view;
	
	public State(View view) {
		this.view = view;
	}
	
	public abstract void showUi();
	public abstract void finish();
}
