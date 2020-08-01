package Command;

public class UndoCommand implements Command {
    private Command control;

    public UndoCommand(Command control) {
        System.out.print("還原  --");
        this.control = control;
    }

    @Override
    public void use() {
        control.undo();
    }

    @Override
    public void undo() {

    }
}
