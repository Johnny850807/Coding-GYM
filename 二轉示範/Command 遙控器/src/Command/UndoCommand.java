package Command;

public class UndoCommand implements Command{
	private Command command;
	
	public UndoCommand(Command command){
		this.command = command;
	}
	
	@Override
	public void execute() {
		System.out.print(" ¡Ÿ≠Ï  -- ");
		command.undo();
	}

	@Override
	public void undo() {
		command.execute();
	}

}
