import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public class ManPanel extends JPanel
{
   public ManPanel()
   {
       this.setBackground(null);
       setLayout(new BorderLayout());
       setPreferredSize(new Dimension(500, 300) );
       this.setVisible(true);
       this.repaint(); 
   }
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       g.fillRect(0, 0, 200, 200);
   }
}
