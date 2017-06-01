import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
public class ImgSequence
{
    protected ArrayList<Image> imgs;
    private int currentIdx;
    public ImgSequence()
    {
        imgs = new ArrayList<Image>();
        currentIdx = 0;
    }
    public Image nextImge()
    {
        currentIdx = (currentIdx+1)%imgs.size();
        return imgs.get(currentIdx);
    }
    public int getCurrentIdx()
    {
        return currentIdx;
    }
    public void addImge(Image img)
    {
        imgs.add(img);
    }
}
