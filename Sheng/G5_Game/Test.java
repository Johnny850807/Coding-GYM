public class Test
{
    public static void main(String[] argv)
    {
        Model model = new Model(99);
        View view = new View();
        Controller controller = new Controller(model,view);
    }
}
