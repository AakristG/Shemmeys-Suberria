import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Turkey class which extends Ingredient
 */
public class Turkey extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Turkey object with the png file
   */
  public Turkey(){
    setEvaluator(2);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Turkey.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Turkey Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
      return  "- Turkey";
  }
}