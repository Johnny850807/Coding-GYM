import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public class GamePanel extends JPanel
{
    private Image backGroundImage;
    private TimePanel timePanel;
    public GamePanel()
    {
        String path = "img/";
        try {
            timePanel = new TimePanel();
            backGroundImage = ImageIO.read(new File(path+"background0.jpg"));//讀取背景圖片
            add(timePanel,BorderLayout.NORTH);//加入Panel
        }
        catch (Exception ex) {
              System.out.println("No found Imge!!!!!");
        }
    }
    public void setUpTime(int second)
    {
        timePanel.setUp(second);
    }
    void display() 
    {
       this.setVisible(true);
       this.repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //display the image(src, x, y, width, height, color, observer_call_back)
        int backGroundHeight = getHeight();
        int backGroundWidth = getWidth();
        g.drawImage(backGroundImage,0,0,backGroundWidth,backGroundHeight,null,null); 
    }
}
