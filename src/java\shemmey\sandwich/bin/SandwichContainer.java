/*package shemmey.sandwich.bin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.util.Timer;
import shemmey.sandwich.components.*;

public class SandwichContainer extends JPanel implements ActionListener {

  private Sandwich sandwich;
  private Timer timer;
  private static final int UPDATE_INTERVAL = 10; // in ms
  private boolean[] keys;
  private BufferedImage back;
  
  public SandwichContainer() 
  {
    setBackground(Color.WHITE);
    keys = new boolean[5];

    this.addKeyListener(this);
    timer = new Timer(UPDATE_INTERVAL, this);
    timer.start(); 

    setFocusable(true);
    requestFocus();
    
  }

  public void paintComponent(Graphics window)
  {
    Graphics2D twoDGraph = (Graphics2D) window;

    if(back==null)
      back = (BufferedImage) (createImage(getWidth(), getHeight()));

    Graphics graphToBack = back.createGraphics();

    graphToBack.drawString("Shemmy's Suburbia ", 25, 50);
    graphToBack.setColor(Color.WHITE);
    graphToBack.fillRect(0, 0, 1600, 900);

    twoDGraph.drawImage(back, null, 0, 0);
  }

  private 

  public void actionPerformed(ActionEvent e){
    
  }

  public void keyPressed(KeyEvent e){
    
  }

}
*/