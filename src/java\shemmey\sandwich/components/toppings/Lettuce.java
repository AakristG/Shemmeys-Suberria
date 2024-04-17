package shemmey.sandwich.components.toppings;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;
import shemmey.sandwich.components.Ingredients;

public class Lettuce extends Ingredients{
  private Image image;
  int evaluator;
  public Lettuce(){
    setEvaluator(5);
    try {
      URL url = getClass().getResource("Lettuce.png");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      // feel free to do something here
      System.out.println("Problem with Lettuce Image");
    }
  }

  
  /**
   * Draws the Lettuce in the graphics window
   * 
   * @param window the graphics window
   */
  public void draw(Graphics window) {
   // window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
  }
  
}