import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Lettuce class which extends Ingredient
 */
public class Lettuce extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Lettuce object with the png file
   */
  public Lettuce(){
    setEvaluator(5);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Lettuce.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Lettuce Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Lettuce";
  }
  
}