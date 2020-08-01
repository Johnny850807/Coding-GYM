public class ControlCantUndoException extends RuntimeException {
    public ControlCantUndoException() {
        super("還原  -- 無法還原了");
    }
}
