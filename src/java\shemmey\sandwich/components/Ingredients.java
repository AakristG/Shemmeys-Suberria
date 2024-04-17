package shemmey.sandwich.components;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.awt.*;

public class Ingredients {

  private int evaluator;
  
  public Ingredients() {
    evaluator = -1;
  }

  public void setEvaluator(int e)
  {evaluator = e;}

  public int getEvaluator()
  {return evaluator;}

  public int compareTo(Ingredients i)
  {
    return getEvaluator()-i.getEvaluator();
  }

}