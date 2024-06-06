import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Mayo class which extends Ingredient
 */
public class Mayo extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Mayo object with the png file
   */
  public Mayo(){
    setEvaluator(7);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Mayo.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Mayonnaise Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Mayo";
  }

}