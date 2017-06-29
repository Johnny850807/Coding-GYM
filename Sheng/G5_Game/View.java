import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
public class View extends JFrame
{
    private Controller controller;
    private JFrame jframe;
    private GamePanel gamePanel;
    private int height;
    private int width;
    public View()
    {
        this.controller = null;
        this.gamePanel = new GamePanel();
        this.height = 600;
        this.width = 1300;
        jframe = new JFrame("G5_JAVA_GAME");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(gamePanel);
        jframe.setSize(width,height);
        jframe.validate();
        jframe.setVisible(true);
    }
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void refreshTime(int second)
    {
        gamePanel.setUpTime(second);
    }
    public int getHeight(){return height;}
    public int getWidth(){return width;}
}
