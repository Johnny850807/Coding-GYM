public class Model
{
    private Controller controller;
    private int second;
    public Model(int second)
    {
        this.second = second;
        this.controller = null;
    }
    public int getSecond()
    {
        return second;
    }
    public void setSecond(int second)
    {
        this.second = second;
        controller.notifyTime(this);
    }
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
}
