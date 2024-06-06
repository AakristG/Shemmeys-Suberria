import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * ShemmeysSauce class which extends Ingredient
 */
public class ShemmeysSauce extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a ShemmeysSauce object with the png file
   */
  public ShemmeysSauce(){
    setEvaluator(8);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/SecretSauce.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with ShemmeysSauce Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Shemmeys Sauce";
  }

}