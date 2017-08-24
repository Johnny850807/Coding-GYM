package ButtonCommand;

import java.util.EmptyStackException;
import java.util.Stack;

import RemoteControl.CommandException;



public class UndoCommand implements Command
{
	private Stack<Command> undoCommandStack;
	
	public UndoCommand(Stack<Command> undoCommandStack)
	{ 
		this.undoCommandStack = undoCommandStack;
	}

	@Override
	public void execute()
	{
		if(!undoCommandStack.isEmpty()) 
			undoCommandStack.pop().undo();
		else
			throw new CommandException("無法還原了");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
