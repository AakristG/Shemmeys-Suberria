import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Ingredients class that helps organize the ingredient objects
 */
public class Ingredients {

  private PriorityQueue<Ingredient> ingredients;

  /**
   * Constructs an Ingredients object with a PriorityQueue of type Ingredient
   */
  public Ingredients() {
    ingredients = new PriorityQueue<Ingredient>();
  }
  /**
   * Adds an ingredient to the PriorityQueue
   *
   * @param i the Ingredient object
   */
  public void addIngredient(Ingredient i){
    ingredients.offer(i);
  }

  /**
   * Removes an ingredient from the PriorityQueue
   *
   * @return i the Ingredient object
   */
  public Ingredient removeIngredient(){
    return ingredients.poll();
  }

  /**
   * Method that shows an ingredient from the PriorityQueue
   *
   * @return the first ingredient
   */
  public Ingredient seeIngredient(){
    return ingredients.peek();
  }

  /**
   * Method that accesses the PriorityQueue of each ingredient
   *
   * @return the ingredients as a PriorityQueue
   */
  public PriorityQueue<Ingredient> getIngredients(){
    return ingredients;
  }

  /**
   * Displays each ingredient from the PriorityQueue
   *
   * @return the ingredients
   */
  public String toString(){
    String sent = "";
    PriorityQueue<Ingredient> temp = new PriorityQueue<Ingredient>();
    while(ingredients.size() > 0)
      {
        Ingredient i = ingredients.poll();
        sent += i.toString() + "\n";
        temp.offer(i);
      }
    ingredients = temp;
    return sent;
  }

  /**
   * Displays each ingredient from the PriorityQueue
   *
   * @return the ingredients
   */
  public String processIngreds(){
    String sent = "";
    PriorityQueue<Ingredient> temp = new PriorityQueue<Ingredient>();
    while(ingredients.size() > 0)
      {
        Ingredient i = ingredients.poll();
        sent += i.toString() + "<br><br> ";
        temp.offer(i);
      }
    ingredients = temp;
    return sent;
  }

}