package shemmey.sandwich.bin;
import java.util.*;
import java.io.*;
import java.awt.*;
import shemmey.sandwich.components.*;

public class Order {

boolean toasted;
PriorityQueue<Ingredients> ingredients;

  public Order(boolean t, PriorityQueue<Ingredients> i) {
    toasted = t;
    ingredients = i;
  }

}