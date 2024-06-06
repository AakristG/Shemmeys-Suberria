import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.util.Timer;

/**
 * Initializes all the windows upon launch
 */
public class SandwichContainer {

  private OrderWindow order;
  private GrillWindow grill;
  private BuildWindow build;
  private ReadyWindow ready;
  private ShemmeyFrame gui;

  /**
   * Constructs a SandwichContainer object to initialize the game
   */
  public SandwichContainer() 
  {
    order = new OrderWindow();
    grill = new GrillWindow();
    build = new BuildWindow();
    ready = new ReadyWindow();
    order.setOtherFrames(ready, grill, build);
    grill.setOtherFrames(order, build, ready);
    build.setOtherFrames(order, grill, ready);
    ready.setOtherFrames(order, grill, build);
    gui = new ShemmeyFrame();
    gui.setOrderFrame(order);
    grill.setTicket(order.getTicket());
    build.setTicket(order.getTicket());
    ready.setTicket(order.getTicket());
    grill.setSandwich(order.getSandwich());
    build.setSandwich(order.getSandwich());
    ready.setSandwich(order.getSandwich());
    
  }
}
