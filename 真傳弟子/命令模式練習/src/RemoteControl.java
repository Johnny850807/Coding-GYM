import Command.Command;

import Command.UndoCommand;
import java.util.Stack;

public class RemoteControl {
    private CommandFactory controlAbstractFactory;
    private Stack<Command> usedControls = new Stack<>();

    public void setControlAbstractFactory(CommandFactory controlAbstractFactory) {
        this.controlAbstractFactory = controlAbstractFactory;
    }

    public void useRemoteControl(int select) throws ControlCantUndoException {
        Command command = controlAbstractFactory.createControl(select);
        if (command instanceof UndoCommand) {
        } else {
            usedControls.add(command);
        }
        command.use();
    }

    public Command getLastUsedCommand() throws ControlCantUndoException {
        if (usedControls.isEmpty()) {
            throw new ControlCantUndoException();
        }
        return usedControls.pop();
    }
}
