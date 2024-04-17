package shemmey.sandwich.components.sauce;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;
import shemmey.sandwich.components.Ingredients;

public class ShemmysSauce extends Ingredients{
  private Image image;

  public ShemmysSauce(){
    setEvaluator(7);
    try {
      URL url = getClass().getResource("SecretSauce.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      // feel free to do something here
      System.out.println("Problem with ShemmysSauce Image");
    }
  }

    /**
     * Draws the ShemmysSauce in the graphics window
     * 
     * @param window the graphics window
     */
  public void draw(Graphics window) {
    //window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
  }


}