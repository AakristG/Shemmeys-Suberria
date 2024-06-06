import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Constants class which stores universal game values
 */
public class Constants {

  /**
   * Defines constant values for each window construction and game data values
   */
  public static final class Frames {
    public static final int mainFrameWidth = 1200;
    public static final int mainFrameHeight = 600;
    public static double tips = 0;
  }

  /**
   * Defines animation constants for the Customer objects
   */
  public static final class Customer{
    public static int xVelocity = 1;
    public static int yVelocity = 1;
    public static int xPos = 0;
    public static int yPos = 0;
    public static final int DELAY = 10;
    public static final int SPEED = 1;
  }

  
}