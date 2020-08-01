import Command.Command;

public interface CommandFactory {

    Command createControl(int number) throws ControlCantUndoException;
}
