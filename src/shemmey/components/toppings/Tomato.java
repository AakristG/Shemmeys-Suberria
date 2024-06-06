import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Tomato class which extends Ingredient
 */
public class Tomato extends Ingredient{
  
  private Image image;
  
  /**
   * Constructs a Tomato object with the png file
   */
  public Tomato(){
    setEvaluator(6);
    try {
      URL url = getClass().getResource("src/resources/SandwichComponents/Tomatos.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      System.out.println("Problem with Tomato Image");
    }
  }

  /**
   * Displays the name of the ingredient
   *
   * @return the name of the ingredient
   */
  public String toString(){
    return "- Tomato";
  }
  
}