import javax.imageio.*;
import java.io.*;
public class MagicianImg
{
    private String path;
    private ImgSequence standby;
    private ImgSequence attack;
    private ImgSequence move;
    public MagicianImg()
    {
        super();
        path = "img/MagicianPeople/";
        standby = new ImgSequence();
        attack = new ImgSequence();
        move = new ImgSequence();
        addStandby();
        addAttack();
        addmove();
    }
    protected void addStandby()
    {
        try{
            standby.addImge(ImageIO.read(new File( path + "standby1" + ".png" )));
        }
        catch (Exception ex) {
              System.out.println("No found Imge!!!!!");
        }
    }
    protected void addAttack()
    {
        try{
            attack.addImge(ImageIO.read(new File( path + "attack1" + ".png" )));
            attack.addImge(ImageIO.read(new File( path + "attack2" + ".png" )));
        }
        catch (Exception ex) {
              System.out.println("No found Imge!!!!!");
        }
    }
    protected void addmove()
    {
        try{
            move.addImge(ImageIO.read(new File( path + "walk1" + ".png" )));
            move.addImge(ImageIO.read(new File( path + "walk2" + ".png" )));
        }
        catch (Exception ex) {
              System.out.println("No found Imge!!!!!");
        }
    }
}
