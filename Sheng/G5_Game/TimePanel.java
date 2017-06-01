import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TimePanel extends JPanel
{
    private int second;
    private JLabel timeLabel;
    public TimePanel()
    {
        this.second = 0;
        this.setBackground(null);
        this.setOpaque(false); //設置透明
        String time = String.format("%02d",second);
        timeLabel = new JLabel(time, JLabel.CENTER);
        timeLabel.setForeground(Color.blue);
        timeLabel.setFont(new Font("Courier",Font.BOLD,36));
        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
    }
    public void setUp(int second) 
    {
         this.second = second;
         String time = String.format("%02d",second);
         timeLabel.setText(time);
    }
}
