import java.util.*;
import java.io.*;
import java.awt.*;


/**
 * Sandwich class which implements a Queue and LinkedList to create a sandwich
 */
public class Sandwich {

  Queue<Ingredient> actual;
  boolean toasted;
  
  /**
   * Constructs a sandwich object which stores all of its properties in a Queue of type LinkedList
   */
  public Sandwich() {
    toasted = false;
    actual = new LinkedList<Ingredient>();
  }

  public Queue<Ingredient> getActualIngreds(){return actual;}

  /**
   * Method that checks the boolean of whether the sandwich is toasted
   *
   * @return the boolean of toasted
   */
  public boolean isToasted() {return toasted;}

  /**
   * Method to change the state of sandwich toasted to true
   */
  public void grillSandwich() {toasted = true;}

  /**
   * Adds an ingredient into the Ingredients of current sandwich
   *
   * @param i the Ingredient object
   */
  public void addIngredient(Ingredient i){
    actual.offer(i);
  }

  /**
   * Displays all the ingredients of the player's sandwich
   *
   * @return the string of ingredients of the current sandwich
   */
  public String toString(){
    String sent = "";
    if(toasted)
      sent += "- Toasted\n";
    else
      sent += "- Untoasted\n";
    Queue<Ingredient> temp = new LinkedList<Ingredient>();
    while(actual.size() > 0)
      {
        Ingredient i = actual.poll();
        sent += i.toString() + "\n";
        temp.offer(i);
      }
    actual = temp;
    return sent;
  }

}