import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public abstract class Role extends JPanel
{
   private int x;
   private int heightLenght;
   private int widthLength;
   public Role(int heightLength,int widthLength,int x)
   {
       this.heightLenght = heightLenght;
       this.widthLength = widthLength;
       this.x = x;
       this.setBackground(null);
       this.setOpaque(false);
       this.setLayout(new BorderLayout());
       this.setPreferredSize(new Dimension(widthLength,heightLength));
   }
   public void setX(int x){this.x = x;}
   public int getX(){return x;}
}
