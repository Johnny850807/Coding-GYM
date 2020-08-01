public class PopException extends  RuntimeException {
    public PopException() {
        super("無法pop,堆疊已經空了");
    }
}
