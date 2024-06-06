import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * RoastBeef class which extends Ingredient
 */
public class RoastBeef extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a RoastBeef object with the png file
   */
  public RoastBeef(){
    setEvaluator(1);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/RoastBeef.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with RoastBeef Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- RoastBeef";
  }
  
}