import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Ingredient class that defines ingredient properties
 */
public class Ingredient implements Comparable{

  private int evaluator;

  /**
   * Constructs an Ingredient object with an attached default value
   */
  public Ingredient() {
    evaluator = -1;
  }

  /**
   * Sets a different value attached to the ingredient
   *
   * @param e the number for evaluation
   */
  public void setEvaluator(int e)
  {evaluator = e;}

  /**
   * Method to access the attached number for an ingredient
   *
   * @return the number to be evaluated
   */
  public int getEvaluator()
  {return evaluator;}

  /**
   * Method to access the attached number for an ingredient
   *
   * @param o the Ingredient object
   * @return the difference of priority between ingredients
   */
  public int compareTo(Object o)
  {
    Ingredient i = (Ingredient)o;
    return getEvaluator()-i.getEvaluator();
  }

  /**
   * Displays the priority value
   *
   * @return the number attached to the ingredient
   */
  public String toString(){
    return ""+evaluator;
  }

}