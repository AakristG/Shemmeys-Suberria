import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Cheese class which extends Ingredient
 */
public class Cheese extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Cheese object with the png file
   */
  public Cheese(){
    setEvaluator(3);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Cheeses.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Cheese Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Cheese";
  }

}