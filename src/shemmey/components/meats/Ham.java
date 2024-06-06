import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Ham class which extends Ingredient
 */
public class Ham extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Ham object with the png file
   */
  public Ham(){
    setEvaluator(0);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Ham.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Ham Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Ham";
  }

  

  
}