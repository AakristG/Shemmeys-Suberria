package shemmey.sandwich.components.meats;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.ImageIcon;
import shemmey.sandwich.components.Ingredients;

public class RoastBeef extends Ingredients{
  private Image image;

  public RoastBeef(){
    setEvaluator(0);
    try {
      URL url = getClass().getResource("");
      ImageIcon icon = new ImageIcon(url);
      image = icon.getImage();
    } catch (Exception e) {
      // feel free to do something here
      System.out.println("Problem with RoastBeef Image");
    }
  }

  /**
   * Draws the RoastBeef in the graphics window
   * 
   * @param window the graphics window
   */
  public void draw(Graphics window) {
   // window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
  }
  
}