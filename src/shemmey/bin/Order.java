
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
//import shemmey.sandwich.components.*;
/**
 * Order class which implements a Priority Queue from Ingredients
 */
public class Order {

private boolean toasted;
// private ArrayList<Ingredient> ingreds;
  private Ingredients ingreds;
  /**
   * Constructs an Order object for customers
   */
  public Order() {
    toasted = false;
    ingreds = new Ingredients();
  }
  /**
   * Method that generates a new random order of ingredients
   */
  public void randomGen(){
      Random rand = new Random();
    //meat
    int val = rand.nextInt(3);
    Ingredient meat = new Ingredient();
    switch(val){
      case 0: meat = new Ham();
        break;
      case 1: meat = new RoastBeef();
        break;
      case 2: meat = new Turkey();
    }
    ingreds.addIngredient(meat);
    val = rand.nextInt(2);
    Ingredient sauce = null;
    switch(val){
      case 0: sauce = new Mayo();
        break;
      case 1: sauce = new ShemmeysSauce();
    }
    ingreds.addIngredient(sauce);
    val = rand.nextInt(2);
    switch(val){
      case 0: toasted = false;
        break;
      case 1: toasted = true;
    }
    int amount = rand.nextInt(5);
    Ingredient top1 = new Cheese();
    Ingredient top2 = new Lettuce();
    Ingredient top3 = new Onion();
    Ingredient top4 = new Tomato();
    ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
    temp.add(top1);
    temp.add(top2);
    temp.add(top3);
    temp.add(top4);
    for(int i = 0; i < amount; i++)
      {
        val = rand.nextInt(temp.size());
        ingreds.addIngredient(temp.remove(val));
      }
  }

  /**
   * Method that checks the boolean of whether the sandwich should be toasted
   *
   * @return the boolean of toasted
   */
  public boolean isToasted(){return toasted;}

  
  /**
   * Method that returns all the ingredients of the sandwich
   *
   * @return the Ingredients of a sandwich object
   */
  public Ingredients getIngreds(){return ingreds;}

  /**
   * Displays all the ingredients from the customer order
   *
   * @return the string of ingredients from the order
   */
  public String toString(){
    String sent = "";
    if(ingreds.getIngredients().size() != 0){
    if(toasted)
      sent += "- Toasted\n";
    else
      sent += "- Untoasted\n";
    sent += ingreds.toString();
    }
    else
      sent += "Order is Empty.";
    return sent;
  }

  

}