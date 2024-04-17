import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.io.Exception;

public class OrderWindow extends JFrame {
  private Image backgroundImage;
    public OrderWindow() throws IOException{
      setTitle("Order");
      setSize(1200, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      //background image
      backgroundImage = ImageIO.read(new File("src/resources/Images/ShopBackground.png"));

      
    }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(backgroundImage,0,0,this);
  }
}