package Game;

public interface Observable {
	
	public void register_Adventurers(Observer o);
		
	public void remove_Adventurers(Observer o);
		
	public void notify_Adventurers();
}
