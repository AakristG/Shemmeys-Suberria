import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Onion class which extends Ingredient
 */
public class Onion extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs an Onion object with the png file
   */
  public Onion(){
    setEvaluator(4);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Onions.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Onion Image");
    }
  }
  
  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return "- Onion";
  }
}